package project.example.demo.Mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.example.demo.model.AlarmRecord;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlarmRecordMapperTest {
    @Autowired
    private AlarmRecordMapper alarmRecordMapper;
    @Test
    public void findNew() {
        List<AlarmRecord>alarmRecordList=alarmRecordMapper.findNew(5,7);
        Assert.assertEquals(2,alarmRecordList.size());
        for(AlarmRecord as:alarmRecordList) {
            System.out.println(as.getId());
        }
    }

    @Test
    public void findMaxId(){
       int MAX=alarmRecordMapper.findMaxId();
        System.out.print(MAX);
        Assert.assertEquals(7,MAX);
    }

    @Test
    public void findAllById(){
        List<AlarmRecord> alarmRecordLiST=alarmRecordMapper.findAllById(1715);
        for(AlarmRecord A:alarmRecordLiST)
        {
            System.out.print(A.toString());
        }
        System.out.print(alarmRecordLiST.size());
    }
}