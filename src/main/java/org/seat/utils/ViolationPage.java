package org.seat.utils;

import lombok.Data;
import org.seat.beans.Violation;

import java.util.List;

@Data
public class ViolationPage {
    private List<Violation> violationList;
    private List<Integer> pageList;
    private Integer pageCount;
    private Integer pageNum;

}
