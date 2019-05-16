package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Mapper.AlarmRecordMapper;
import project.example.demo.model.AlarmRecord;

import java.util.List;

@Service
public class AlarmRecordServiceImP implements  AlarmRecordService {
    @Autowired
    private AlarmRecordMapper alarmRecordMapper;
    @Override
    public List<AlarmRecord>findNew(int id1,int id2){
        List<AlarmRecord>alarmRecordList=alarmRecordMapper.findNew(id1,id2);
        return alarmRecordList;
    }
    @Override
    public int findMaxId(){
        int MAX=alarmRecordMapper.findMaxId();
        return MAX;
    }

    @Override
    public List<AlarmRecord>findAllById(int id){
        List<AlarmRecord>alarmRecordList=alarmRecordMapper.findAllById(id);
        return alarmRecordList;
    }

    @Override
     public List<AlarmRecord>findByType(String AlarmType){
        List<AlarmRecord>alarmRecordList=alarmRecordMapper.findByType(AlarmType);
        return alarmRecordList;
    }

    @Override
    public List<AlarmRecord>findByOlderAndType(int id,String AlarmType){
        List<AlarmRecord>alarmRecordList=alarmRecordMapper.findByOlderAndType(id, AlarmType);
        return alarmRecordList;
    }
}
