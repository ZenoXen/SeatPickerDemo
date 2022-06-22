package org.seat.utils;

import lombok.Data;

@Data
public class TipoffRequest {
    private Integer fid;
    private Integer rownum;
    private Integer colnum;
    private String remark;

}
