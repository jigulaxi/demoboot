package szh.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szh.bean.Tblpower;
import szh.mapper.TblpowerMapper;
import szh.service.TblpowerService;

import java.util.List;

@Service
public class TblpowerServiceImpl implements TblpowerService {
    @Autowired
    private TblpowerMapper powerMapper;

    @Override
    public List<Tblpower> getPower(String roleId) {
        List<Tblpower> powers = powerMapper.getPower(roleId);
        return powers;
    }

    @Override
    public List<Tblpower> unAssPower(String roleId) {
        List<Tblpower> powers = powerMapper.unAssPower(roleId);
        return powers;
    }
}
