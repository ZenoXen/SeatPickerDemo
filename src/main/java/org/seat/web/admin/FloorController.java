package org.seat.web.admin;

import org.seat.beans.Floor;
import org.seat.services.FloorService;
import org.seat.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(value = "/floor")
@Controller
public class FloorController {
    @Autowired
    private FloorService floorService;
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Floor> floors(){
        return floorService.getAllFloors();
    }
    @ResponseBody
    @RequestMapping(value = "/{fid}",method = RequestMethod.GET)
    public Floor floor(@PathVariable("fid") int fid){
        return floorService.getFloorById(fid);
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Message addFloor(@RequestBody Floor floor){
        Message message=new Message();
        message.setSuccessful(floorService.addFloor(floor));
        return message;
    }
    @ResponseBody
    @RequestMapping(value = "/{fid}",method = RequestMethod.DELETE)
    public Message deleteFloor(@PathVariable("fid") int fid){
        Message message=new Message();
        message.setSuccessful(floorService.deleteFloor(fid));
        return message;
    }
}
