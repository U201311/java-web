package project.example.demo.Mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.example.demo.model.User;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void findUserByName() {
       User user= userMapper.findUserByName("liying");
        Assert.assertEquals("123456",user.getPassword());
    }

}