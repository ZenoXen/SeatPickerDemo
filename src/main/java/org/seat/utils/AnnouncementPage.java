package org.seat.utils;

import lombok.Data;
import org.seat.beans.Announcement;

import java.util.List;

@Data
public class AnnouncementPage {
    private List<Announcement> announcementList;
    private List<Integer> pageList;
    private Integer pageCount;
    private Integer pageNum;

}
