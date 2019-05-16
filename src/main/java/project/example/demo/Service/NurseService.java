package project.example.demo.Service;

import project.example.demo.model.Nurse;

import java.util.List;

public interface NurseService {
    Nurse findById(int id);

    List<Nurse>findAll();
}
