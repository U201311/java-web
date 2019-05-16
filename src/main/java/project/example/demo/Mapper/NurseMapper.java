package project.example.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import project.example.demo.model.Nurse;

import java.util.List;

@Mapper
public interface NurseMapper {

    @Select("select * from nurse where id=#{id} ")
    Nurse  findById(@Param("id") int id);

    @Select("select * from nurse")
    List<Nurse> findAll();

}
