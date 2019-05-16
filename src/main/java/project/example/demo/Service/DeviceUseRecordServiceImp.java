package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Mapper.DeviceUseRecordMapper;
import project.example.demo.model.DeviceUseRecord;

import java.util.List;

@Service
public class DeviceUseRecordServiceImp implements DeviceUseRecordService {

    @Autowired
    private DeviceUseRecordMapper deviceUseRecordMapper;

    @Override
   public  List<DeviceUseRecord> finByOlderId(int id){
        List<DeviceUseRecord>deviceUseRecordList=deviceUseRecordMapper.findByOlderId(id);
        return  deviceUseRecordList;
    }

    @Override
    public void insertNew(DeviceUseRecord deviceUseRecord){
        deviceUseRecordMapper.insertNew(deviceUseRecord);
    }

    @Override
     public List<DeviceUseRecord>finByDeviceType(String deviceType){
        return  deviceUseRecordMapper.findByDeviceType(deviceType);
    }

    @Override
    public List<DeviceUseRecord>finByOlderAndType(int oldersId,String deviceType){
        List<DeviceUseRecord>deviceUseRecordList=deviceUseRecordMapper.findByOlderAndDevice(oldersId, deviceType);
        return deviceUseRecordList;
    }
}
