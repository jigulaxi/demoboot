package szh.mapper;

import org.apache.ibatis.annotations.Mapper;
import szh.bean.Tblrole;

import java.util.List;

@Mapper
public interface TblroleMapper {

    public List<Tblrole> getRole();
}
