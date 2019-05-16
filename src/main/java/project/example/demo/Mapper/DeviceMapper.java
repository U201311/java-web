package project.example.demo.Mapper;

import org.apache.ibatis.annotations.*;
import project.example.demo.model.Device;

import java.util.List;

@Mapper
public interface DeviceMapper {

    @Select("select * from device where devicename=#{deviceName}")
    List<Device> findByType(@Param("deviceName") String deviceName);

    @Select("select * from device where deviceId=#{deviceId}")
    Device findById(@Param("deviceId")int deviceId);

    @Select("select * from device")
    List<Device> findAll();

    @Select("select * from device where deviceId=#{deviceId} and deviceName=#{deviceName}")
    Device findByIdAndType(@Param("id")int id,@Param("deviceName") String name);

    @Insert("insert into device (deviceId,deviceName) values (#{device.deviceId},#{device.deviceName})")
    void insertNewDevice(@Param("device") Device device);

    @Delete("delete * from device where deviceId=#{deviceId}")
    void Delete(@Param("deviceId") int deviceId);


}
