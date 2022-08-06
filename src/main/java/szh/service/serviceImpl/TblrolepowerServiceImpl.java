package szh.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szh.bean.Tblpower;
import szh.mapper.TblpowerMapper;
import szh.mapper.TblrolepowerMapper;
import szh.service.TblrolepowerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TblrolepowerServiceImpl implements TblrolepowerService {
    @Autowired
    private TblrolepowerMapper tblrolepowerMapper;
    @Autowired
    private TblpowerMapper tblpowerMapper;
    @Override
    public boolean reducePower(String roleId, String powerId) {
        int re = tblrolepowerMapper.reducePower(roleId,powerId);
        if (re!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addPower(String roleId, String powerId) {
        int re = tblrolepowerMapper.addPower(roleId,powerId);
        if (re!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addAllRolePower(String roleId) {
        List<Tblpower> powerList = tblpowerMapper.getUnAssPower(roleId);
        List powerIdList = new ArrayList();
        for (Tblpower power:powerList){
            powerIdList.add(power.getPowerId());
        }
        int re =tblrolepowerMapper.addAllRolePower(roleId,powerIdList);
        if (re!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean reduceAllRolePower(String roleId) {
        List<Tblpower> powerList = tblpowerMapper.getAssPower(roleId);
        List powerIdList = new ArrayList();
        for (Tblpower power:powerList){
            powerIdList.add(power.getPowerId());
        }
        int re =tblrolepowerMapper.reduceAllRolePower(roleId,powerIdList);
        if (re!=0){
            return true;
        }
        return false;
    }
}
