package project.example.demo.Controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import project.example.demo.Mapper.OlderMapper;
import project.example.demo.Service.OlderAndBedServiceImp;
import project.example.demo.Service.OlderAndDeviceServiceImp;
import project.example.demo.Service.OlderServiceImp;
import project.example.demo.model.Bed;
import project.example.demo.model.Device;
import project.example.demo.model.Older;

import java.util.List;

@RestController
@RequestMapping(value="/older")
public class OlderController {

    @Autowired
    private OlderServiceImp olderServiceImp;

    @Autowired
    private OlderAndBedServiceImp olderAndBedServiceImp;
    @Autowired
    private OlderAndDeviceServiceImp olderAndDeviceServiceImp;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Older> findAll(){
        List<Older>olderList=olderServiceImp.findAllOlder();
        //System.out.print(olderList.size());
        return olderList;
    }

    @RequestMapping(value = "/findById/{olderId}")
    @ResponseBody
    public Older findById(@PathVariable("olderId")int olderId){
        Older older=olderServiceImp.findById(olderId);
        return older;
    }

    @RequestMapping(value = "/findBedById/{oldersId}")
    @ResponseBody
    public Bed findBedByOlder(@PathVariable("oldersId") int oldersId){
        Bed bed=olderAndBedServiceImp.findByOlderId(oldersId);
        return bed;
    }

    @RequestMapping(value = "/findDeviceById/{oldersId}/{deviceName}")
    @ResponseBody
   public Device findByOlderAndType(@PathVariable("oldersId") int oldersId, @PathVariable("deviceName") String deviceName){
        Device device=olderAndDeviceServiceImp.findByOlderIdAndType(oldersId,deviceName);
        return  device;
   }

   @RequestMapping(value = "/addOlder")
   @ResponseBody
    public void insertOlder(@RequestBody  Older older){
        olderServiceImp.insertOlder(older);
   }

   @RequestMapping(value = "/findBySex/{sex}")
   @ResponseBody
    public List<Older> findBySex(@PathVariable("sex") String sex){
        List<Older>olderList=olderServiceImp.findBySex(sex);
        return olderList;
   }

    @RequestMapping(value = "/findByHealthyState/{healthyState}")
    @ResponseBody
    public List<Older>findByHealthyState(@PathVariable("healthyState") String healthyState){
        List<Older> olderList=olderServiceImp.findByHealthyState(healthyState);
       return olderList;
    }

    @RequestMapping(value = "/deleteOlder/{olderId}")
    @ResponseBody
    public void delereOlder(@PathVariable("olderId") int id){
        olderServiceImp.deleteOlder(id);
    }
}
