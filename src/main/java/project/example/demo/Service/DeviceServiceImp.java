package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Mapper.DeviceMapper;
import project.example.demo.model.Device;

import java.util.List;

@Service
public class DeviceServiceImp implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;
    @Override
   public List<Device>findAll(){
        List<Device>deviceList=deviceMapper.findAll();
        return deviceList;
    }

    @Override
    public List<Device>findByType(String type){
        List<Device>deviceList=deviceMapper.findByType(type);
        return  deviceList;
    }

    @Override
    public void insertNew(Device device){
        deviceMapper.insertNewDevice(device);
    }

    @Override
    public Device findByDeviceId(int id){
        Device device=deviceMapper.findById(id);
        return device;
    }

    @Override
    public void Delete(int deviceId){
        deviceMapper.Delete(deviceId);
    }
}
