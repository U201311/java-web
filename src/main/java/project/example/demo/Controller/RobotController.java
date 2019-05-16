package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.example.demo.Service.RobotServiceImp;
import project.example.demo.model.Robot;

import java.util.List;

@RestController
@RequestMapping(value="/robot")
public class RobotController {
    @Autowired
    private RobotServiceImp robotServiceImp;

    @RequestMapping(value="/findAll")
    @ResponseBody
    public List<Robot>findAll(){
        List<Robot>robotList=robotServiceImp.findAll();
        return robotList;
    }

    @RequestMapping(value = "/findByType/{robotName}")
    @ResponseBody
    public List<Robot>findByType(@PathVariable("robotName") String robotName)
    {
        List<Robot>robotList=robotServiceImp.findByType(robotName);
        return robotList;
    }

    @RequestMapping(value = "/findById/{id}")
    @ResponseBody
    public Robot findById(@PathVariable("id") int id)
    {
        Robot robot=robotServiceImp.findById(id);
        return robot;
    }
}

