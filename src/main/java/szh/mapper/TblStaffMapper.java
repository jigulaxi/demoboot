package szh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import szh.bean.Tblstaff;
import szh.bean.Tbluser;

import java.util.List;

@Mapper
public interface TblStaffMapper {

    public Tblstaff login(@Param("staffAcc") String staffAcc,
                          @Param("staffPwd") String staffPwd);
    public List<Tblstaff> getStaffList();

    public int delStaff(@Param("staffId") String staffId);

    public int updStaff(@Param("staffAcc") String staffAcc,
                        @Param("staffPwd") String staffPwd,
                        @Param("roleId") String roleId,
                        @Param("staffName") String staffName,
                        @Param("staffAdd") String staffAdd,
                        @Param("staffId") String staffId);
}
