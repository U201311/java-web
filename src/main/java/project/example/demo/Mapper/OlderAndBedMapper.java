package project.example.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import project.example.demo.model.OlderAndBed;

import java.util.List;

@Mapper
public interface OlderAndBedMapper {

    @Select("select  * from oldersbeddistribution")
    List<OlderAndBed>findAll();

    @Select("select  bedId from oldersbeddistribution where oldersId=#{oldersId}")
    int findBedByOlder(@Param("oldersId") int oldersId);
}
