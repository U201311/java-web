package project.example.demo.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import project.example.demo.model.Device;
import project.example.demo.model.OlderAndDevice;

import javax.persistence.Id;
import java.util.List;

@Mapper
public interface OlderAndDeviceMapper {

    @Select("select * from oldersdevicedistribution")
    List<OlderAndDevice>findAllRel();

    @Select("select oldersdevicedistribution.deviceId from oldersdevicedistribution where oldersId=#{oldersId}")
    List<Integer>findByOlderId(int oldersId);

    @Insert({"insert into oldersdevicedistribution (oldersId,deviceId) values (#{oldersId},#{deviceId})"})
    void insertNewRel(OlderAndDevice olderAndDevice);

    @Select("select d.DeviceId,d.deviceName from device d join oldersdevicedistribution o on d.DeviceId=o.deviceID where o.oldersId=#{oldersId} and d.deviceName=#{deviceName}")
    Device findByOldersIdAndType(@Param("oldersId")int oldersId,@Param("deviceName") String deviceName);
}
