package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.example.demo.Mapper.NurseMapper;
import project.example.demo.Service.NurseServiceImp;
import project.example.demo.model.Nurse;

import java.util.List;

@RestController
@RequestMapping(value = "/nurse")
public class NurseController {
    @Autowired
    private NurseServiceImp nurseServiceImp;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Nurse>findAll(){
        List<Nurse>nurseList=nurseServiceImp.findAll();
        return nurseList;
    }
    @RequestMapping(value = "/findById/{id}")
    @ResponseBody
    public Nurse findAll(@PathVariable ("id") int id){
        Nurse nurse=nurseServiceImp.findById(id);
        return nurse;
    }
}
