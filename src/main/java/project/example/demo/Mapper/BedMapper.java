package project.example.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import project.example.demo.model.Bed;

import java.util.List;

@Mapper
public interface BedMapper {

    @Select("select * from bed where id=#{id}")
    Bed findById(@Param("id") int id);

    @Select("select * from bed")
    List<Bed>findAllBed();
}
