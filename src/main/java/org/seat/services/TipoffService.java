package org.seat.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.seat.beans.Tipoff;
import org.seat.beans.User;
import org.seat.beans.UserExample;
import org.seat.mappers.TipoffMapper;
import org.seat.mappers.UserMapper;
import org.seat.mappers.ViolationMapper;
import org.seat.utils.PageUtils;
import org.seat.utils.TimeUtils;
import org.seat.utils.TipoffPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TipoffService {
    @Autowired
    private TipoffMapper tipoffMapper;
    @Autowired
    private ViolationMapper violationMapper;
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public boolean verifyTipoff(int tid) {
        Tipoff tipoff = tipoffMapper.getTipoffById(tid);
        int ret1 = violationMapper.insertViolation(tipoff.getAccused().getUid(), tipoff.getTtime(), tipoff.getSeat().getSid());
        int ret2 = tipoffMapper.deleteTipoff(tid);
        User accused = tipoff.getAccused();
        UserExample ue = new UserExample();
        UserExample.Criteria criteria = ue.createCriteria();
        criteria.andUidEqualTo(accused.getUid());
        accused.setUnlockTime(TimeUtils.getAutoUnlockTime(new Date()));
        accused.setIsforbidden((byte) 1);
        System.out.println(accused);
        int ret3 = userMapper.updateByExampleSelective(accused, ue);
        return ret1 + ret2 + ret3 == 3;
    }

    @Transactional
    public boolean addTipoff(int accusedId, int tipsterId, int sid, String remark) {
        return tipoffMapper.insertTipoff(accusedId, new Date(), tipsterId, sid, remark) > 0;
    }

    public Tipoff getTipoffById(int tid) {
        return tipoffMapper.getTipoffById(tid);
    }

    public TipoffPage getTipoffPage(int pageNum) {
        TipoffPage tipoffPage = new TipoffPage();
        Page<Tipoff> page = PageHelper.startPage(pageNum, PageUtils.pageSize);
        page.setReasonable(true);
        List<Tipoff> tipoffs = tipoffMapper.getAllTipoffRecords();
        PageInfo<Tipoff> pageInfo = new PageInfo<Tipoff>(tipoffs, PageUtils.pageListSize);
        tipoffPage.setTipoffList(tipoffs);
        tipoffPage.setPageNum(pageNum);
        tipoffPage.setPageList(PageUtils.parsePageList(pageInfo.getNavigatepageNums()));
        tipoffPage.setPageCount(pageInfo.getPages());
        return tipoffPage;
    }
}
