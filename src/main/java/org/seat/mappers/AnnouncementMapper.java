package org.seat.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.seat.beans.Announcement;
import org.seat.beans.AnnouncementExample;

public interface AnnouncementMapper {
    Announcement selectLatest();
    long countByExample(AnnouncementExample example);

    int deleteByExample(AnnouncementExample example);

    int deleteByPrimaryKey(Integer announcementId);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    List<Announcement> selectByExampleWithBLOBs(AnnouncementExample example);

    List<Announcement> selectByExample(AnnouncementExample example);

    Announcement selectByPrimaryKey(Integer announcementId);

    int updateByExampleSelective(@Param("record") Announcement record, @Param("example") AnnouncementExample example);

    int updateByExampleWithBLOBs(@Param("record") Announcement record, @Param("example") AnnouncementExample example);

    int updateByExample(@Param("record") Announcement record, @Param("example") AnnouncementExample example);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKeyWithBLOBs(Announcement record);

    int updateByPrimaryKey(Announcement record);
}