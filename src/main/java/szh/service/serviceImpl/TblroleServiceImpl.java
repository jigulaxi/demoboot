package szh.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szh.bean.Tblrole;
import szh.mapper.TblroleMapper;
import szh.service.TblroleService;

import java.util.List;

@Service
public class TblroleServiceImpl implements TblroleService {
    @Autowired
    private TblroleMapper roleMapper;
    @Override
    public List<Tblrole> getRole() {
        List<Tblrole> roles=roleMapper.getRole();
        return roles;
    }
}
