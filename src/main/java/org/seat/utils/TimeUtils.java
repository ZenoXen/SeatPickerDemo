package org.seat.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils {
    public static final int auto_release_minute=40;
    public static final int auto_unlock_hour=24;
    public static Date getAutoReleaseTime(Date atime){
        Calendar calendar=new GregorianCalendar();
        calendar.setTime(atime);
        calendar.add(Calendar.MINUTE, TimeUtils.auto_release_minute);
        return calendar.getTime();
    }
    public static Date getAutoUnlockTime(Date date){
        Calendar calendar=new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, TimeUtils.auto_unlock_hour);
        return calendar.getTime();
    }
    public static int calculateTimeDiff(Date former,Date later){
        return (int)(later.getTime()-former.getTime())/1000/60;
    }
}
