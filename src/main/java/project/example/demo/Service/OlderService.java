package project.example.demo.Service;

import project.example.demo.model.Older;

import java.util.List;

public interface OlderService {

    List<Older>findAllOlder();
    Older findById(int id);
    void  insertOlder(Older older);
    List<Older>findBySex(String sex);
    List<Older>findByHealthyState(String healthyState);
    void deleteOlder(int id);
}
