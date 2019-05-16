package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.example.demo.Service.OlderAndFamilyServiceImp;
import project.example.demo.model.Family;

import java.util.List;

@RestController
@RequestMapping(value = "/family")
public class OlderFamilyController {
    @Autowired
    private OlderAndFamilyServiceImp olderAndFamilyServiceImp;

    @RequestMapping(value = "/findFamily/{olderId}")
    @ResponseBody
    public List<Family>findFamily(@PathVariable("olderId") int oldersId){
        List<Family>familyList=olderAndFamilyServiceImp.findFamilyByOlderId(oldersId);
        return familyList;
    }
}
