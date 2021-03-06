import org.junit.Test;
import org.junit.runner.RunWith;
import org.seat.mappers.FloorMapper;
import org.seat.services.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:rootConfig.xml"})
public class FloorTest {
    @Autowired
    FloorService service;
    @Test
    public void testFloor(){
        System.out.println(service.getFloorById(1));
        System.out.println(service.getAllFloors());
    }
}
