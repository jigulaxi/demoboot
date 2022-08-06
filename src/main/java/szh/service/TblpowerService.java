package szh.service;

import szh.bean.Tblpower;

import java.util.List;

public interface TblpowerService {

    public List<Tblpower> getPower(String roleId);

    public List<Tblpower> unAssPower(String roleId);
}
