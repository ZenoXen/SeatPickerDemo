package org.seat.mappers;

import java.util.Date;
import java.util.List;

import org.seat.beans.Violation;

public interface ViolationMapper {
    List<Violation> getAllViolationRecords();
    Violation getViolationById(Integer vid);
    int insertViolation(int uid,Date vdate,int sid);
    int deleteViolation(int vid);
    List<Violation> getAllViolationRecordsByUid(int uid);
}