package org.seat.utils;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {
    public static final int pageSize=8;
    public static final int pageListSize=5;
    public static List<Integer> parsePageList(int[] pageList){
        List<Integer> ret=new ArrayList<Integer>();
        for(int page:pageList)
            ret.add(page);
        return ret;
    }
}
