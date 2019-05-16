package project.example.demo.Service;

import project.example.demo.model.Device;
import project.example.demo.model.OlderAndDevice;

import java.util.List;

public interface OlderAndDeviceService {
    //查找所有关联设备
    List<Device> findByOlderId(int oldersId);

    void insertNew(OlderAndDevice olderAndDevice);


    Device findByOlderIdAndType(int olderId,String type);

}
