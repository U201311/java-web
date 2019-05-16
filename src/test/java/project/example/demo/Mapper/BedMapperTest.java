package project.example.demo.Mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.example.demo.model.Bed;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BedMapperTest {
    @Autowired
    private BedMapper bedMapper;

    @Test
    public void findById() {
        Bed bed=bedMapper.findById(510101);
        System.out.print(bed.toString());
    }
}