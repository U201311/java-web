package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.example.demo.Service.DeviceServiceImp;
import project.example.demo.model.Device;

import java.util.List;

@RestController
@RequestMapping(value = "/device")
public class DeviceController {

    @Autowired
    private DeviceServiceImp deviceServiceImp;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Device>findAll(){
        List<Device>deviceList=deviceServiceImp.findAll();
        return  deviceList;
    }

    @RequestMapping(value = "/findByType/{type}")
    @ResponseBody
    public List<Device>findByType(@PathVariable("type") String type){
        List<Device>deviceList=deviceServiceImp.findByType(type);
        return  deviceList;
    }

    @RequestMapping(value = "/addNewDevice")
    @ResponseBody
    public void addNewDevice(@RequestBody Device device){
        deviceServiceImp.insertNew(device);
    }

    @RequestMapping(value = "/findDeviceById/{deviceId}")
    @ResponseBody
    public Device findDeviceById(@PathVariable("deviceId") int id) {
      Device device=deviceServiceImp.findByDeviceId(id);
      return device;
    }

    @RequestMapping(value = "/deleteDevice/{deviceId}")
    @ResponseBody
    public void DeleteDevice(@PathVariable("deviceId") int deviceId){
        deviceServiceImp.Delete(deviceId);
    }
}
