package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Mapper.DeviceMapper;
import project.example.demo.Mapper.OlderAndDeviceMapper;
import project.example.demo.model.Device;
import project.example.demo.model.OlderAndDevice;

import java.util.ArrayList;
import java.util.List;

@Service
public class OlderAndDeviceServiceImp implements OlderAndDeviceService{
    @Autowired
    private OlderAndDeviceMapper olderAndDeviceMapper;
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<Device> findByOlderId(int oldersId){
        List<Integer>integerList=olderAndDeviceMapper.findByOlderId(oldersId);
        List<Device>deviceList=new ArrayList<>();
        for(Integer i : integerList)
        {
            deviceList.add(deviceMapper.findById(i));
        }
        return  deviceList;
    }
    @Override
    public Device findByOlderIdAndType(int olderId,String type){
       Device device=olderAndDeviceMapper.findByOldersIdAndType(olderId,type);
       return device;
    }
    @Override
    public void insertNew(OlderAndDevice olderAndDevice){
        olderAndDeviceMapper.insertNewRel(olderAndDevice);
    }
}
