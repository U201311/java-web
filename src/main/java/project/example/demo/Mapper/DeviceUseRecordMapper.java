package project.example.demo.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import project.example.demo.model.DeviceUseRecord;

import java.util.List;

@Mapper
public interface DeviceUseRecordMapper {

    @Select("select * from deviceuserecord where OldersId=#{olderId} ")
    List<DeviceUseRecord>findByOlderId(int olderId);

    @Insert({"insert into deviceuserecord  (DeviceId,OldersId ,NurseId,OlderName,NurseName,DeviceType,BeginTime,EndTime ) values (#{deviceUseRecord.deviceId}, #{deviceUseRecord.oldersId},#{deviceUseRecord.nurseId}, #{deviceUseRecord.OlderName},#{deviceUseRecord.NurseName},#{deviceUseRecord.DeviceType},#{deviceUseRecord.beginTime} ,#{deviceUseRecord.endTime} )"})
    void insertNew(@Param("deviceUseRecord") DeviceUseRecord deviceUseRecord);

    @Select("select * from deviceuserecord where DeviceType=#{deviceType}")
    List<DeviceUseRecord>findByDeviceType(@Param("deviceType")String deviceType);

    @Select("select *from deviceuserecord where OldersId=#{oldersId} AND DeviceType=#{deviceType}")
    List<DeviceUseRecord>findByOlderAndDevice(@Param("oldersId") int oldersId,@Param("deviceType")  String deviceType);

}
