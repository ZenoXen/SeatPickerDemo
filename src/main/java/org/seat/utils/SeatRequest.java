package org.seat.utils;

import lombok.Data;

@Data
public class SeatRequest {
    private Integer sid;
    private Integer fid;
    private Integer seatStatus;
    private Integer uid;
    private Integer rownum;
    private Integer colnum;
}
