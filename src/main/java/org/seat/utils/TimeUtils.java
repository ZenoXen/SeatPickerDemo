package org.seat.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils {
    public static final int AUTO_RELEASE_MINUTE = 40;
    public static final int AUTO_UNLOCK_HOUR = 24;

    public static Date getAutoReleaseTime(Date atime) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(atime);
        calendar.add(Calendar.MINUTE, TimeUtils.AUTO_RELEASE_MINUTE);
        return calendar.getTime();
    }

    public static Date getAutoUnlockTime(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, TimeUtils.AUTO_UNLOCK_HOUR);
        return calendar.getTime();
    }

    public static int calculateTimeDiff(Date former, Date later) {
        return (int) (later.getTime() - former.getTime()) / 1000 / 60;
    }
}
