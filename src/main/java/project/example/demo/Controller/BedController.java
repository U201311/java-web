package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.example.demo.Service.BedServiceImp;
import project.example.demo.model.Bed;

import java.util.List;

@RestController
@RequestMapping(value = "/bed")
public class BedController {
    @Autowired
    private BedServiceImp  bedServiceImp;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Bed> findAllBed(){
        List<Bed>bedList=bedServiceImp.findAll();
        return bedList;
    }
}
