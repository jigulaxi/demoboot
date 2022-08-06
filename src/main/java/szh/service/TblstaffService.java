package szh.service;

import szh.bean.Tblstaff;

import java.util.List;

public interface TblstaffService {

    public Tblstaff login(String staffAcc, String staffPwd);

    public List<Tblstaff> getStaffList();

    public int delStaff(String staffId);

    public int updStaff(String staffAcc, String staffPwd, String roleId, String staffName, String staffAdd, String staffId);
}
