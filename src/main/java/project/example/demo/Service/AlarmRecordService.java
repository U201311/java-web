package project.example.demo.Service;

import project.example.demo.model.AlarmRecord;

import java.util.List;

public interface AlarmRecordService {
    List<AlarmRecord>findNew(int id1,int id2);

    int findMaxId();

    List<AlarmRecord>findAllById(int id);

    List<AlarmRecord>findByType(String AlarmType);

    List<AlarmRecord>findByOlderAndType(int id,String AlarmType);
}
