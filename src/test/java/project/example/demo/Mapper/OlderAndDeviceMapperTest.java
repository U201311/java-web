package project.example.demo.Mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import project.example.demo.model.Device;
import project.example.demo.model.OlderAndDevice;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class OlderAndDeviceMapperTest {
@Autowired
private OlderAndDeviceMapper olderAndDeviceMapper;
    @Test
    public void findAllRel() {
        List<OlderAndDevice>olderAndDeviceList=olderAndDeviceMapper.findAllRel();
        Assert.assertEquals(3,olderAndDeviceList.size());
    }
    @Test
    public void findByOlderId(){
        List<Integer>integerList=olderAndDeviceMapper.findByOlderId(1715);
        Assert.assertEquals(1,integerList.size());
    }

    @Test
    public void insertOlder(){
        OlderAndDevice olderAndDevice=new OlderAndDevice(1901,774);
        olderAndDeviceMapper.insertNewRel(olderAndDevice);
    }
    @Test
    public void findByOldersIdAndType(){
        Device device=olderAndDeviceMapper.findByOldersIdAndType(1715,"跌倒检测定位终端");
        System.out.print(device.toString());
    }
}