import org.junit.Test;
import org.junit.runner.RunWith;
import org.seat.mappers.SeatMapper;
import org.seat.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:rootConfig.xml"})
public class SeatTest {
    @Autowired
    private SeatService service;
    @Autowired
    private SeatMapper mapper;
    @Test
    public void testSeat(){
        System.out.println(service.registerSeat(49,3,3));
        System.out.println(service.cancelSeat(49,4,3));
        System.out.println(service.releaseSeat(49,5,4));
    }
}
