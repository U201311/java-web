package project.example.demo.Service;

import project.example.demo.model.Device;

import java.util.List;

public interface DeviceService {

    List<Device>findAll();

    List<Device>findByType(String type);

    void insertNew(Device device);

    Device findByDeviceId(int id);

    void Delete(int deviceId);
}
