package szh.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szh.bean.Tblstaff;
import szh.mapper.TblStaffMapper;
import szh.service.TblstaffService;

import java.util.List;

@Service
public class TblstaffServiceImpl implements TblstaffService {
    @Autowired
    private TblStaffMapper staffMapper;
    @Override
    public Tblstaff login(String staffAcc, String staffPwd) {
        Tblstaff staff = staffMapper.login(staffAcc,staffPwd);
        return staff;
    }

    @Override
    public List<Tblstaff> getStaffList() {
        List<Tblstaff> staffList = staffMapper.getStaffList();
        return staffList;
    }

    @Override
    public int delStaff(String staffId) {
        int re = staffMapper.delStaff(staffId);
        return re;
    }

    @Override
    public int updStaff(String staffAcc, String staffPwd, String roleId, String staffName, String staffAdd, String staffId) {
        int re = staffMapper.updStaff(staffAcc,staffPwd,roleId,staffName,staffAdd,staffId);
        return re;
    }
}
