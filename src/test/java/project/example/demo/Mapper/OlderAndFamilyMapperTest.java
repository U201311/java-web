package project.example.demo.Mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OlderAndFamilyMapperTest {
   @Autowired
   private  OlderAndFamilyMapper olderAndFamilyMapper;

    @Test
    public void selectFamilyByOlder() {
        List<Integer>LIAS=olderAndFamilyMapper.selectFamilyByOlder(1715);
        System.out.print("========================"+LIAS.size());
    }
}