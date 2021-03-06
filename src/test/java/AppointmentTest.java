
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seat.beans.Appointment;
import org.seat.beans.User;
import org.seat.mappers.AppointmentMapper;
import org.seat.mappers.UserMapper;
import org.seat.services.AppointmentService;
import org.seat.utils.AppointmentPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:rootConfig.xml"})
public class AppointmentTest {
    @Autowired
    private AppointmentService service;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testAppointment(){

    }
}
