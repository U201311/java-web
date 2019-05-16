package project.example.demo.Mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.example.demo.model.Nurse;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NurseMapperTest {
    @Autowired
    private NurseMapper nurseMapper;

    @Test
    public void findById() {
        Nurse nurse=nurseMapper.findById(1);
        System.out.print(nurse.toString());
    }
}