package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Mapper.FamilyMapper;
import project.example.demo.Mapper.OlderAndFamilyMapper;
import project.example.demo.model.Family;

import java.util.ArrayList;
import java.util.List;

@Service
public class OlderAndFamilyServiceImp implements OlderAndFamilyService {

    @Autowired
    private OlderAndFamilyMapper olderAndFamilyMapper;

    @Autowired
    private FamilyMapper familyMapper;

    @Override
    public List<Family> findFamilyByOlderId(int oldersId){
        List<Integer>integerList=olderAndFamilyMapper.selectFamilyByOlder(oldersId);
        List<Family>familyList=new ArrayList<>();
        for(int i:integerList)
        {
           Family family=familyMapper.selectFamily(i);
           familyList.add(family);
        }
        return familyList;
    }

}
