package org.seat.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.seat.beans.Announcement;
import org.seat.beans.AnnouncementExample;
import org.seat.mappers.AnnouncementMapper;
import org.seat.utils.AnnouncementPage;
import org.seat.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementMapper mapper;

    public AnnouncementPage getAnnouncementPage(int pageNum) {
        AnnouncementPage announcementPage = new AnnouncementPage();
        Page<Announcement> page = PageHelper.startPage(pageNum, PageUtils.pageSize);
        page.setReasonable(true);
        AnnouncementExample ae = new AnnouncementExample();
        AnnouncementExample.Criteria criteria = ae.createCriteria();
        criteria.andAnnouncementIdIsNotNull();
        List<Announcement> announcements = mapper.selectByExample(ae);
        PageInfo<Announcement> pageInfo = new PageInfo<Announcement>(announcements, PageUtils.pageListSize);
        announcementPage.setAnnouncementList(announcements);
        announcementPage.setPageNum(pageNum);
        announcementPage.setPageList(PageUtils.parsePageList(pageInfo.getNavigatepageNums()));
        announcementPage.setPageCount(pageInfo.getPages());
        return announcementPage;
    }

    public Announcement getAnnouncementById(int announcementId) {
        return mapper.selectByPrimaryKey(announcementId);
    }

    @Transactional
    public boolean updateAnnouncement(Announcement announcement) {
        AnnouncementExample ae = new AnnouncementExample();
        AnnouncementExample.Criteria criteria = ae.createCriteria();
        criteria.andAnnouncementIdEqualTo(announcement.getAnnouncementId());
        int result = mapper.updateByExampleSelective(announcement, ae);
        return result > 0;
    }

    @Transactional
    public boolean deleteAnnoucementById(Announcement announcement) {
        return mapper.deleteByPrimaryKey(announcement.getAnnouncementId()) > 0;
    }

    @Transactional
    public boolean addAnnouncement(Announcement announcement) {
        return mapper.insert(announcement) > 0;
    }

    public Announcement getLatest() {
        return mapper.selectLatest();
    }
}
