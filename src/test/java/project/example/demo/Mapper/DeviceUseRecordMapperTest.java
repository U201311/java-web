package project.example.demo.Mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.example.demo.model.DeviceUseRecord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeviceUseRecordMapperTest {

    @Autowired
    private  DeviceUseRecordMapper deviceUseRecordMapper;
    @Test
    public void findByOlderId() {
    }

    @Test
    public void insertNew() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // 这里填写的是想要进行转换的时间格式
        String str1 = "2019-1201-11 17:17:10";
        String str2 = "2019-1201-11 18:17:10";
        Date date = null;
        Date date1 = null;
        try{
            date = format.parse(str1);
            date1 = format.parse(str2);
           DeviceUseRecord deviceUseRecord=new DeviceUseRecord(101,1715,1,"张武祥","张女士","助浴机器人",date,date1);
           deviceUseRecordMapper.insertNew(deviceUseRecord);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}