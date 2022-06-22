package org.seat.utils;

import lombok.Data;
import org.seat.beans.User;

import java.util.List;

@Data
public class UserPage {
    private List<User> userList;
    private List<Integer> pageList;
    private Integer pageCount;
    private Integer pageNum;

}
