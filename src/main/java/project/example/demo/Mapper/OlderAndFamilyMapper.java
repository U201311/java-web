package project.example.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OlderAndFamilyMapper {
    @Select("select  oldersfamilyrelation.familyId from oldersfamilyrelation where oldersId=#{oldersId}")
    List<Integer>selectFamilyByOlder(@Param("oldersId") int oldersId);
}
