package szh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TblrolepowerMapper {

    public int reducePower(@Param("roleId") String roleId,
                           @Param("powerId") String powerId);

    public int addPower(@Param("roleId") String roleId,
                        @Param("powerId") String powerId);

    public int addAllRolePower(@Param("roleId") String roleId,
                               @Param("powerIdList") List powerIdList);
    public int reduceAllRolePower(@Param("roleId") String roleId,
                                  @Param("powerIdList") List powerIdList);

}
