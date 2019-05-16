package project.example.demo.Service;

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
@SpringBootTest
public class OlderAndDeviceServiceImpTest {
@Autowired
private OlderAndDeviceServiceImp olderAndDeviceServiceImp;
    @Test
    public void findByOlderId() {
        List<Device>deviceList=olderAndDeviceServiceImp.findByOlderId(1715);
       Assert.assertEquals(2,deviceList.size());
    }

}