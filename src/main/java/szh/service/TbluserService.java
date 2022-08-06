package szh.service;

import szh.bean.Tbluser;

import java.util.List;

public interface TbluserService {

    public List<Tbluser> findUser();

    public int delUser(String userId);

    public int addUser(String uAcc, String uPwd, String uName, String phone, String idNumber, String address);

    public int updUser(String upduAcc, String upduPwd, String upduName, String updphone, String updidNumber, String updaddress, String userId);

}
