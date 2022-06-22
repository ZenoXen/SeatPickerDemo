package org.seat.mappers;

import org.seat.beans.Floor;

import java.util.List;

public interface FloorMapper {
    Floor getFloorById(int fid);

    List<Floor> getAllFloors();

    int addFloor(Floor floor);

    Floor getFloorByName(String fname);

    int deleteFloor(int fid);
}
