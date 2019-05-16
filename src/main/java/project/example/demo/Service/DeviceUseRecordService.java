package project.example.demo.Service;

import org.apache.ibatis.annotations.Param;
import project.example.demo.model.DeviceUseRecord;

import java.util.List;

public interface DeviceUseRecordService {

    List<DeviceUseRecord>finByOlderId(int olderId);

    void insertNew( DeviceUseRecord deviceUseRecord);

    List<DeviceUseRecord>finByDeviceType(String deviceType);

    List<DeviceUseRecord>finByOlderAndType(int oldersId,String deviceType);
}
