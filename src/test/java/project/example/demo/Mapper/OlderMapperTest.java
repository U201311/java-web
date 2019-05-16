package project.example.demo.Mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.example.demo.model.Older;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OlderMapperTest {
    @Autowired
    private OlderMapper olderMapper;

    @Test
    public void findAllOlders() {
        List<Older> olderList=olderMapper.findAllOlders();
       Assert.assertEquals(14,olderList.size());
    }
    @Test
    public void findById(){
        Older older=olderMapper.findById(1715);
        System.out.print(older.toString());
    }

    @Test
    public void insert(){
        Older older=new Older(1901,"张三",88,"男","全自理（一级）");
        olderMapper.insertOlder(older);
    }

    @Test
    public void findByAge(){
        List<Older>olderList=olderMapper.findByAge(60);
        System.out.print("=========="+olderList.size()+"==========");
    }
}