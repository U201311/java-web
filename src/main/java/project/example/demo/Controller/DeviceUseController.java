package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.example.demo.Service.DeviceUseRecordServiceImp;
import project.example.demo.model.DeviceUseRecord;

import java.util.List;

@RestController
@RequestMapping(value = "/deviceUse")
public class DeviceUseController {
    @Autowired
    private DeviceUseRecordServiceImp deviceUseRecordServiceImp;

    @RequestMapping(value="/addNewRecord", method={RequestMethod.POST})
    @ResponseBody
    public void insertNewRecord(@RequestBody DeviceUseRecord UseRecord){
       // System.out.print(UseRecord.getDeviceId());
        deviceUseRecordServiceImp.insertNew(UseRecord);
    }

    @RequestMapping(value="/findByOlder/{olderId}")
    @ResponseBody
    public List<DeviceUseRecord> findByOlder(@PathVariable("olderId") int olderId){
        List<DeviceUseRecord> deviceUseRecordList=deviceUseRecordServiceImp.finByOlderId(olderId);
        return deviceUseRecordList;
    }

    @RequestMapping(value="/findByDeviceType/{DeviceType}")
    @ResponseBody
    public List<DeviceUseRecord> findByDeviceType(@PathVariable("DeviceType") String DeviceType){
        List<DeviceUseRecord> deviceUseRecordList=deviceUseRecordServiceImp.finByDeviceType(DeviceType);
        return deviceUseRecordList;
    }

    @RequestMapping(value="/findByOlderAndDevice/{oldersId}/{DeviceType}")
    @ResponseBody
    public List<DeviceUseRecord> findByOlderAndDevice( @PathVariable("oldersId") int oldersId,@PathVariable("DeviceType") String deviceType){
        List<DeviceUseRecord> deviceUseRecordList=deviceUseRecordServiceImp.finByOlderAndType(oldersId, deviceType);
        return deviceUseRecordList;
    }

}
