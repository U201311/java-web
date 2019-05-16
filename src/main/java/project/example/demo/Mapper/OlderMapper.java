package project.example.demo.Mapper;

import org.apache.ibatis.annotations.*;
import project.example.demo.model.Older;

import java.util.List;

@Mapper
public interface OlderMapper {

    @Select("select * from olders")
    List<Older> findAllOlders();

    @Select("select * from olders where id=#{id}")
    Older findById(int id);

    @Insert({"insert into olders (id,name ,age,sex,healthyState,IdNumber,InDate,Nation,Remarks ) values (#{id}, #{name}, #{age} ,#{sex} ,#{healthyState},#{IdNumber},#{InDate},#{Nation},#{Remarks})"})
    void insertOlder(@Param("Older") Older older);

    @Select("select * from olders where sex=#{sex}")
    List<Older>findBySex(@Param("sex")String sex);

    @Select("select  *from olders where healthyState=#{healthyState}")
    List<Older>findByHealthyState(@Param("healthyState") String healthyState);

    @Select("select * from olders where age>=#{age} and age<=#{age+5}")
    List<Older>findByAge(int age);

    @Delete("delete from olders where id=#{id}")
    void deleteOlder(@Param("id") int id);
}
