package org.seat.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.seat.beans.Violation;
import org.seat.mappers.UserMapper;
import org.seat.mappers.ViolationMapper;
import org.seat.utils.PageUtils;
import org.seat.utils.ViolationPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service
@Slf4j
public class ViolationService {
    @Autowired
    private ViolationMapper violationMapper;
    @Autowired
    private UserMapper userMapper;

    public ViolationPage getViolationPage(int pageNum) {
        ViolationPage violationPage = new ViolationPage();
        Page<Violation> page = PageHelper.startPage(pageNum, PageUtils.pageSize);
        page.setReasonable(true);
        List<Violation> violations = violationMapper.getAllViolationRecords();
        PageInfo<Violation> pageInfo = new PageInfo<Violation>(violations, PageUtils.pageListSize);
        violationPage.setViolationList(violations);
        violationPage.setPageNum(pageNum);
        violationPage.setPageList(PageUtils.parsePageList(pageInfo.getNavigatepageNums()));
        violationPage.setPageCount(pageInfo.getPages());
        return violationPage;
    }

    public boolean deleteViolation(int vid) {
        return violationMapper.deleteViolation(vid) > 0;
    }

    public ViolationPage getViolationPageByUid(int pageNum, int uid) {
        ViolationPage violationPage = new ViolationPage();
        Page<Violation> page = PageHelper.startPage(pageNum, PageUtils.pageSize);
        page.setReasonable(true);
        List<Violation> violations = violationMapper.getAllViolationRecordsByUid(uid);
        PageInfo<Violation> pageInfo = new PageInfo<Violation>(violations, PageUtils.pageListSize);
        violationPage.setViolationList(violations);
        violationPage.setPageNum(pageNum);
        violationPage.setPageList(PageUtils.parsePageList(pageInfo.getNavigatepageNums()));
        violationPage.setPageCount(pageInfo.getPages());
        return violationPage;
    }

    //定时任务解冻违规用户
    @Scheduled(fixedRate = 60000)
    public void scheduledUnlockAllViolationUser() {
        log.info("自动解冻违规用户");
        userMapper.unlockDisabledUsers();
    }
}
