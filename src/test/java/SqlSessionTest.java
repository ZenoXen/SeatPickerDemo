
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seat.beans.Floor;
import org.seat.mappers.SeatMapper;
import org.seat.services.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:rootConfig.xml"})
public class SqlSessionTest {
    @Autowired
    FloorService service;
    @Test
    public void testSqlSession() {
        Floor floor=new Floor();
        floor.setFname("123");
        floor.setRow(30);
        floor.setCol(30);
        System.out.println(service.addFloor(floor));
    }
}
