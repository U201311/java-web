package project.example.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import project.example.demo.model.AlarmRecord;

import java.util.List;

@Mapper
public interface AlarmRecordMapper {
    @Select("select * from devicealarmrecord where id <= #{id2} and id > #{id1}")
    List<AlarmRecord>findNew(@Param("id1") int id1, @Param("id2") int id2);

    @Select("select max(id) from devicealarmrecord")
    int findMaxId();

    @Select("select *from devicealarmrecord where oldersId =#{olderId}   ")
    List<AlarmRecord>findAllById(@Param("olderId")int olderId);


    @Select("select * from devicealarmrecord  where  AlarmType=#{AlarmType}")
    List<AlarmRecord>findByType(@Param("AlarmType") String AlarmType);

    @Select("select * from devicealarmrecord where oldersId =#{oldersId} And AlarmType=#{AlarmType}")
    List<AlarmRecord>findByOlderAndType(@Param("oldersId") int oldersId,@Param("AlarmType") String deviceType) ;
}
