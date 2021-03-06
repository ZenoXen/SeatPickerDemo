import org.junit.Test;
import org.junit.runner.RunWith;
import org.seat.beans.User;
import org.seat.mappers.UserMapper;
import org.seat.mappers.ViolationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:rootConfig.xml"})
public class ViolationTest {
    @Autowired
    ViolationMapper violationMapper;
    @Test
    public void testViolation(){
        violationMapper.insertViolation(71,new Date(),3);
        System.out.println(violationMapper.getAllViolationRecords());
    }
}
