package szh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import szh.bean.Tbluser;
import szh.service.TbluserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private TbluserService tbluserService;

    @RequestMapping("/userList")
    public String userList(Model model){
        System.out.println("userList------");

        //c--->service
        List<Tbluser> userList = tbluserService.findUser();
        model.addAttribute("userList",userList);
        return "userList";
    }

    @RequestMapping("/delUser")
    public String delUser(String userId,Model model){
        int re = tbluserService.delUser(userId);
        model.addAttribute("re",re);
        return "userList";
    }

    @RequestMapping("/addUser")
    public @ResponseBody boolean addUser(String uAcc, String uPwd, String uName, String phone, String idNumber, String address){
        int AddRe = tbluserService.addUser(uAcc,uPwd,uName,phone,idNumber,address);
        if (AddRe!=0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/updUser")
    public @ResponseBody boolean updUser(String upduAcc, String upduPwd, String upduName, String updphone, String updidNumber, String updaddress,String userId){
        int updRe = tbluserService.updUser(upduAcc,upduPwd,upduName,updphone,updidNumber,updaddress,userId);
        if (updRe!=0){
            return true;
        }else {
            return false;
        }
    }

}
