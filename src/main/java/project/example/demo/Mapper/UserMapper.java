package project.example.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import project.example.demo.model.User;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User findUserByName(String username);
}
