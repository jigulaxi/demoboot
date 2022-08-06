package szh.service;

import java.util.List;

public interface TblrolepowerService {

    public boolean reducePower(String roleId, String powerId);

    public boolean addPower(String roleId, String powerId);

    public boolean addAllRolePower(String roleId);

    public boolean reduceAllRolePower(String roleId);
}
