package project.example.demo.Service;

import project.example.demo.model.Bed;
import project.example.demo.model.OlderAndBed;

import java.util.List;

public interface OlderAndBedService {

    List<OlderAndBed>findAll();

    Bed findByOlderId(int oldersId);


}
