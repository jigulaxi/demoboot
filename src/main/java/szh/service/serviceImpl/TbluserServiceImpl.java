package szh.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szh.bean.Tbluser;
import szh.mapper.TblUserMapper;
import szh.service.TbluserService;

import java.util.List;

@Service
public class TbluserServiceImpl implements TbluserService {

    @Autowired
    private TblUserMapper userMapper;

    @Override
    public List<Tbluser> findUser() {
        List<Tbluser> userList = userMapper.findUser();
        return userList;
    }

    @Override
    public int delUser(String userId) {
        int re = userMapper.delUser(userId);
        return re;
    }

    @Override
    public int addUser(String uAcc, String uPwd, String uName, String phone, String idNumber, String address) {
        int re = userMapper.addUser(uAcc,uPwd,uName,phone,idNumber,address);
        return re;
    }

    @Override
    public int updUser(String upduAcc, String upduPwd, String upduName, String updphone, String updidNumber, String updaddress, String userId) {
        int re = userMapper.updUser(upduAcc,upduPwd,upduName,updphone,updidNumber,updaddress,userId);
        return re;
    }
}
