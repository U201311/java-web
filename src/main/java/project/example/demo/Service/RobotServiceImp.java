package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Mapper.RobotMapper;
import project.example.demo.model.Bed;
import project.example.demo.model.Robot;

import java.util.List;

@Service
public class RobotServiceImp implements RobotService {
    @Autowired
    private RobotMapper robotMapper;

    @Override
    public List<Robot> findAll(){
        List<Robot>RobotList=robotMapper.findAll();
        return RobotList;
    }
    @Override
    public void insert(Robot robot){
        robotMapper.insertRobot(robot);
    }

    @Override
    public List<Robot>findByType(String robotName){
        List<Robot>robotList=robotMapper.findByType(robotName);
        return robotList;
    }
    @Override
    public Robot findById(int id){
        Robot robot =robotMapper.findById(id);
        return robot;
    }

}
