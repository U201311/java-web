package project.example.demo.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import project.example.demo.model.Robot;

import java.util.List;

@Mapper
public interface RobotMapper {

    @Select("select * from robot")
    List<Robot> findAll();

    @Insert("insert into robot (id,robotName) values(#{id},#{robotName})")
    void insertRobot(@Param("Robot") Robot robot);

    @Select("select * from robot where robotName=#{robotName}")
    List<Robot>findByType(@Param("robotName") String robotName);

    @Select("select * from robot where id=#{id}")
    Robot findById(@Param("id") int id);
}
