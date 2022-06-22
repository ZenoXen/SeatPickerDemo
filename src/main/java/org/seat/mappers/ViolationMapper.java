package org.seat.mappers;

import org.seat.beans.Violation;

import java.util.Date;
import java.util.List;

public interface ViolationMapper {
    List<Violation> getAllViolationRecords();

    Violation getViolationById(Integer vid);

    int insertViolation(int uid, Date vdate, int sid);

    int deleteViolation(int vid);

    List<Violation> getAllViolationRecordsByUid(int uid);
}