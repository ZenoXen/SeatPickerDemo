import org.junit.Test;
import org.junit.runner.RunWith;
import org.seat.beans.Floor;
import org.seat.beans.User;
import org.seat.mappers.FloorMapper;
import org.seat.mappers.SeatMapper;
import org.seat.mappers.TipoffMapper;
import org.seat.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:rootConfig.xml"})
public class TipoffTest {
    @Autowired
    FloorMapper floorMapper;
    @Autowired
    SeatMapper seatMapper;
    @Autowired
    TipoffMapper tipoffMapper;
    @Autowired
    UserMapper userMapper;
    @Test
    public void testTipoff(){
        for(int i=0;i<30;i++){
            tipoffMapper.insertTipoff(69,new Date(),70,3,"222");
        }
    }
}
