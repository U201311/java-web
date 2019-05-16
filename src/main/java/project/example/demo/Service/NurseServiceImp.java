package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Mapper.NurseMapper;
import project.example.demo.model.Nurse;

import java.util.List;

@Service
public class NurseServiceImp implements NurseService {

    @Autowired
    private NurseMapper nurseMapper;
    @Override
    public Nurse findById(int id){
        Nurse nurse=nurseMapper.findById(id);
        return  nurse;
    }

    @Override
    public List<Nurse> findAll(){
        List<Nurse>nurseList=nurseMapper.findAll();
        return nurseList;
    }

}
