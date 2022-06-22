package org.seat.utils;

import lombok.Data;
import org.seat.beans.Tipoff;

import java.util.List;

@Data
public class TipoffPage {
    private List<Tipoff> tipoffList;
    private List<Integer> pageList;
    private Integer pageCount;
    private Integer pageNum;

}
