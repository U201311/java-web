package project.example.demo.Task;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import project.example.demo.Config.WebsocketServer;
import project.example.demo.Service.AlarmRecordServiceImP;
import project.example.demo.model.AlarmRecord;

import java.util.List;

@Component
public class Task {
    private static int MAX_ID=1;
    private static final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private AlarmRecordServiceImP alarmRecordServiceImP;
    @Scheduled(fixedRate = 10000)
    public void sendMsg(){
        try {
            int id = alarmRecordServiceImP.findMaxId();
            //System.out.print(id);
            if (id > MAX_ID) {
                List<AlarmRecord> alarmRecordList = alarmRecordServiceImP.findNew(MAX_ID, id);
                String updateInfo = mapper.writeValueAsString(alarmRecordList);
                //System.out.print(updateInfo);
                WebsocketServer.sendInfo(updateInfo);
                MAX_ID = id;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("推送失败");
        }
    }
}
