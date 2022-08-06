package szh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import szh.bean.Tbluser;

import java.util.List;

@Mapper
public interface TblUserMapper {


    public List<Tbluser> findUser();

    public int delUser(@Param("userId") String userId);

    public int addUser(@Param("uAcc") String uAcc,
                       @Param("uPwd") String uPwd,
                       @Param("uName") String uName,
                       @Param("phone") String phone,
                       @Param("idNumber") String idNumber,
                       @Param("address") String address);

    public int updUser(@Param("upduAcc") String upduAcc,
                       @Param("upduPwd") String upduPwd,
                       @Param("upduName") String upduName,
                       @Param("updphone") String updphone,
                       @Param("updidNumber") String updidNumber,
                       @Param("updaddress") String updaddress,
                       @Param("userId") String userId);
}
