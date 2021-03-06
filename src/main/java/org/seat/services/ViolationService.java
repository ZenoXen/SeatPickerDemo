package org.seat.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.seat.beans.User;
import org.seat.beans.UserExample;
import org.seat.beans.Violation;
import org.seat.mappers.ViolationMapper;
import org.seat.utils.PageUtils;
import org.seat.utils.UserPage;
import org.seat.utils.ViolationPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service
public class ViolationService {
    @Autowired
    ViolationMapper violationMapper;
    public ViolationPage getViolationPage(int pageNum){
        ViolationPage violationPage=new ViolationPage();
        Page<Violation> page= PageHelper.startPage(pageNum, PageUtils.pageSize);
        page.setReasonable(true);
        List<Violation> violations=violationMapper.getAllViolationRecords();
        PageInfo<Violation> pageInfo=new PageInfo<Violation>(violations,PageUtils.pageListSize);
        violationPage.setViolationList(violations);
        violationPage.setPageNum(pageNum);
        violationPage.setPageList(PageUtils.parsePageList(pageInfo.getNavigatepageNums()));
        violationPage.setPageCount(pageInfo.getPages());
        return violationPage;
    }
    public boolean deleteViolation(int vid){
        return violationMapper.deleteViolation(vid)>0;
    }
    public ViolationPage getViolationPageByUid(int pageNum,int uid){
        ViolationPage violationPage=new ViolationPage();
        Page<Violation> page= PageHelper.startPage(pageNum, PageUtils.pageSize);
        page.setReasonable(true);
        List<Violation> violations=violationMapper.getAllViolationRecordsByUid(uid);
        PageInfo<Violation> pageInfo=new PageInfo<Violation>(violations,PageUtils.pageListSize);
        violationPage.setViolationList(violations);
        violationPage.setPageNum(pageNum);
        violationPage.setPageList(PageUtils.parsePageList(pageInfo.getNavigatepageNums()));
        violationPage.setPageCount(pageInfo.getPages());
        return violationPage;
    }
}
