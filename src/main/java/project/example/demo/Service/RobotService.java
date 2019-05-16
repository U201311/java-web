package project.example.demo.Service;

import project.example.demo.model.Robot;

import java.util.List;

public interface RobotService {
    List<Robot>findAll();

    void insert(Robot robot);

    List<Robot>findByType(String robotName);

    Robot findById(int id);
}
