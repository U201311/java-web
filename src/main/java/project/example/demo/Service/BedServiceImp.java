package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Mapper.BedMapper;
import project.example.demo.model.Bed;

import java.util.List;

@Service
public class BedServiceImp implements  BedService {
    @Autowired
    private BedMapper bedMapper;
    @Override
    public List<Bed> findAll(){
        List<Bed>bedList=bedMapper.findAllBed();
        return bedList;
    }
}
