package org.seat.services;

import org.seat.beans.Floor;
import org.seat.beans.Seat;
import org.seat.mappers.FloorMapper;
import org.seat.mappers.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FloorService {
    @Autowired
    private FloorMapper floorMapper;
    @Autowired
    private SeatMapper seatMapper;

    public Floor getFloorById(int fid) {
        return floorMapper.getFloorById(fid);
    }

    public List<Floor> getAllFloors() {
        return floorMapper.getAllFloors();
    }

    @Transactional
    public boolean addFloor(Floor floor) {
        boolean ret1 = addFloorBeforeSeats(floor);
        if (!ret1) return false;
        floor = floorMapper.getFloorByName(floor.getFname());
        boolean ret2 = addSeatsForFloor(floor);
        return ret2;
    }

    @Transactional
    public boolean deleteFloor(int fid) {
        return floorMapper.deleteFloor(fid) > 0;
    }

    @Transactional
    protected boolean addFloorBeforeSeats(Floor floor) {
        if (floorMapper.getFloorByName(floor.getFname()) != null)
            return false;
        return floorMapper.addFloor(floor) > 0;
    }

    @Transactional
    protected boolean addSeatsForFloor(Floor floor) {
        int row = floor.getRow(), col = floor.getCol();
        int total = row * col;
        int cnt = 0;
        ArrayList<Seat> seats = new ArrayList<Seat>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Seat seat = new Seat();
                seat.setFloor(floor);
                seat.setRownum(i + 1);
                seat.setColnum(j + 1);
                seats.add(seat);
                cnt++;
            }
        }
        seatMapper.addSeatsForFloor(seats);
        return cnt == total;
    }
}
