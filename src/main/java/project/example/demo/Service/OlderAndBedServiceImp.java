package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Mapper.BedMapper;
import project.example.demo.Mapper.OlderAndBedMapper;
import project.example.demo.model.Bed;
import project.example.demo.model.OlderAndBed;

import java.util.List;

@Service
public class OlderAndBedServiceImp implements OlderAndBedService {
    @Autowired
    private OlderAndBedMapper olderAndBedMapper;
    @Autowired
    private BedMapper bedMapper;

    @Override
    public List<OlderAndBed> findAll(){
        List<OlderAndBed>olderAndBedList=olderAndBedMapper.findAll();
        return olderAndBedList;
    }

    @Override
    public Bed findByOlderId(int oldersId){
        int bedId=olderAndBedMapper.findBedByOlder(oldersId);
        Bed bed=bedMapper.findById(bedId);
        return bed;
    }
}
