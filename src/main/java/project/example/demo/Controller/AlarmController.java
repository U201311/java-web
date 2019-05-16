package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.example.demo.Service.AlarmRecordServiceImP;
import project.example.demo.Task.Task;
import project.example.demo.model.AlarmRecord;

import java.util.List;

@RestController
@RequestMapping(value = "/alarm")
public class AlarmController {

    @Autowired
    private AlarmRecordServiceImP alarmRecordServiceImP;

    @RequestMapping(value = "/start")
    @ResponseBody
    public void startTimer(){
        Task task=new Task();
    }

    @RequestMapping(value = "/findByOlderId/{oldersId}")
    @ResponseBody
    public List<AlarmRecord> findByOlderId(@PathVariable("oldersId")int oldersId){
        //System.out.print(oldersId);
        List<AlarmRecord>alarmRecordList=alarmRecordServiceImP.findAllById(oldersId);
        return alarmRecordList;
    }

    @RequestMapping(value = "/findByType/{type}")
    @ResponseBody
    public List<AlarmRecord> findByType(@PathVariable("type")String type){
        //System.out.print(oldersId);
        List<AlarmRecord>alarmRecordList=alarmRecordServiceImP.findByType(type);
        return alarmRecordList;
    }

    @RequestMapping(value = "findByOlderAndType/{oldersId}/{alarmType}")
    @ResponseBody
    public List<AlarmRecord> findByOlderAndType(@PathVariable("oldersId") int oldersId,@PathVariable("alarmType") String alarmType){
        List<AlarmRecord>alarmRecordList=alarmRecordServiceImP.findByOlderAndType(oldersId, alarmType);
        return alarmRecordList;
    }

}
