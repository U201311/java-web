package project.example.demo.Mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.example.demo.model.Device;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeviceMapperTest {
@Autowired
private DeviceMapper deviceMapper;
    @Test
    public void findByType() {
        List<Device>deviceList=deviceMapper.findByType("大小便离床检测终端");
        Assert.assertEquals(4,deviceList.size());
    }
  @Test
    public void insertNewDevice(){
      deviceMapper.insertNewDevice(new Device(288,"大小便离床检测终端"));
  }
}