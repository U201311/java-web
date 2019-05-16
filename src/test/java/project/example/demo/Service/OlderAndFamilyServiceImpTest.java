package project.example.demo.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.example.demo.Mapper.FamilyMapper;
import project.example.demo.Mapper.OlderAndFamilyMapper;
import project.example.demo.model.Family;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OlderAndFamilyServiceImpTest {


    @Autowired
    private OlderAndFamilyMapper olderAndFamilyMapper;

    @Autowired
    private FamilyMapper familyMapper;
    @Test
    public void findFamilyByOlderId() {
        List<Integer> integerList=olderAndFamilyMapper.selectFamilyByOlder(1715);
        List<Family>familyList=new ArrayList<>();
        for(int i:integerList)
        {
            Family family=familyMapper.selectFamily(i);
            System.out.print("========"+family.toString()+"=======");
            familyList.add(family);
        }
       System.out.print("========"+familyList.size()+"=======");
    }
}