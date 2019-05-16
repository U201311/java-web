package project.example.demo.Mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OlderAndBedMapperTest {

    @Autowired
    private OlderAndBedMapper olderAndBedMapper;

    @Test
    public void findBedByOlder() {
        int id=olderAndBedMapper.findBedByOlder(1715);
        System.out.print(id);
    }
}