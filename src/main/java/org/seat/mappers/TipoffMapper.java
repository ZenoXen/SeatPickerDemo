package org.seat.mappers;

import org.seat.beans.Tipoff;

import java.util.Date;
import java.util.List;

public interface TipoffMapper {
    int insertTipoff(int accused_id, Date ttime, int tipster_id,int sid,String remark);
    int deleteTipoff(int tid);
    Tipoff getTipoffById(int tid);
    List<Tipoff> getAllTipoffRecords();
}
