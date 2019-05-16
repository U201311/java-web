package project.example.demo.Service;

import project.example.demo.model.Family;

import java.util.List;

public interface OlderAndFamilyService {
    List<Family>findFamilyByOlderId(int oldersId);
}
