package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Mapper.UserMapper;
import project.example.demo.model.User;

@Service
public class UserServiceImp implements UserService {
    @Autowired
     private UserMapper userMapper;
    @Override
    public boolean  findUserByname(String username,String password){
       User user= userMapper.findUserByName(username);
       if(user.getPassword().equals(password))
           return true;
       else
       return false;
    }
}
