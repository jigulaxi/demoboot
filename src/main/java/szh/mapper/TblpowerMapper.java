package szh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import szh.bean.Tblpower;

import java.util.List;

@Mapper
public interface TblpowerMapper {

    public List<Tblpower> getPower(@Param("roleId") String roleId);

    public List<Tblpower> unAssPower(@Param("roleId") String roleId);

    public List<Tblpower> getAssPower(@Param("roleId") String roleId);

    public List<Tblpower> getUnAssPower(@Param("roleId") String roleId);
}
