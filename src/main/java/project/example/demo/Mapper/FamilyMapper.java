package project.example.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import project.example.demo.model.Family;

@Mapper
public interface FamilyMapper {

    @Select("select * from family where id=#{id}")
    Family selectFamily(@Param("id") int id);
}
