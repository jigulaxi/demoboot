package szh.controller;

import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import szh.bean.Tblpower;
import szh.bean.Tblrole;
import szh.bean.Tblstaff;
import szh.service.TblpowerService;
import szh.service.TblroleService;
import szh.service.TblrolepowerService;
import szh.service.TblstaffService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private TblstaffService staffService;
    @Autowired
    private TblpowerService tblpowerService;
    @Autowired
    private TblroleService tblroleService;
    @Autowired
    private TblrolepowerService tblrolepowerService;
    @RequestMapping("/loginView")
    public String login(){
        return "login";//页面名称
    }

    @RequestMapping(value="/doLogin",produces= MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    public @ResponseBody String doLogin(String staffAcc, String staffPwd){
        System.out.println("doLogin----------"+staffAcc+","+staffPwd);
        Tblstaff staff = staffService.login(staffAcc,staffPwd);
        String uobj = JSONArray.toJSONString(staff);
        System.out.println(uobj);
        return uobj;

    }

    @RequestMapping("/regionView")
    public String region(){
        return "regionView";
    }

    @RequestMapping("/doRegion")
    public String doRegion(MultipartFile fname, String account, HttpServletRequest req){
        System.out.println(fname);
        String fn = fname.getOriginalFilename();
        System.out.println(fn);
        try {
            String url5=req.getServletContext().getRealPath("/upload");
            System.out.println(url5);
            File file = new File(url5);
            if (!file.exists()){
                file.mkdir();
            }
            fname.transferTo(new File(url5+"/"+fn));//保存FIle
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "login";
    }
    @RequestMapping("/checkacc")
    public @ResponseBody String checkAccount(@RequestBody String userName){
        System.out.println(userName);
        return "1";
    }

    @RequestMapping("/index")
    public String getIndex(Model model, Tblstaff staff){
        model.addAttribute("staff",staff);
        return "index";
    }

    @RequestMapping("/getPower")
    public @ResponseBody
    List<Tblpower> getPower(String roleId){
        List<Tblpower> powers = tblpowerService.getPower(roleId);
        return powers;
    }

    @RequestMapping("/power")
    public String power(){
        return "power";
    }

    @RequestMapping("getRole")
    public @ResponseBody
    List<Tblrole> getRole(Model model){
        List<Tblrole> roles =tblroleService.getRole();
        return roles;
    }
    @RequestMapping("getRolePower")
    public @ResponseBody
    Map<String,List<Tblpower>> getRolePower(Model model,String roleId){
        HashMap<String,List<Tblpower>> map = new HashMap<>();
        List<Tblpower> assRoles = tblpowerService.getPower(roleId);
        List<Tblpower> unassRoles = tblpowerService.unAssPower(roleId);
        map.put("assPower",assRoles);
        map.put("unassRoles",unassRoles);
        return map;
    }
    @RequestMapping("addPower")
    public @ResponseBody
    boolean addPower(String powerId,String roleId){
        boolean flag = tblrolepowerService.addPower(roleId,powerId);
        return flag;
    }
    @RequestMapping("reducePower")
    public @ResponseBody
    boolean reducePower(String powerId,String roleId){
        boolean flag = tblrolepowerService.reducePower(roleId,powerId);
        return flag ;
    }

    @RequestMapping("addAllPower")
    public @ResponseBody boolean addAllPower(String roleId){
        boolean re = tblrolepowerService.addAllRolePower(roleId);
        return re;
    }

    @RequestMapping("reduceAllPower")
    public @ResponseBody boolean reduceAllPower(String roleId){
        boolean re =tblrolepowerService.reduceAllRolePower(roleId);
        return re;
    }

    @RequestMapping(value = "getStaffList",produces= MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    public @ResponseBody String getStaffList(){
        List<Tblstaff> staffList = staffService.getStaffList();
        String sList=JSONArray.toJSONString(staffList);
        System.out.println("11-------"+sList);
        return sList;
    };

    @RequestMapping(value = "delStaff",produces= MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    public @ResponseBody String delStaff(String staffId){
        int re = staffService.delStaff(staffId);
        if (re!=0){
            return "success";
        }
        return "fail";
    }
    @RequestMapping(value = "updStaff",produces= MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    public @ResponseBody String updStaff(@RequestBody Tblstaff staff){
        System.out.println(staff.getStaffName());
        //int re = staffService.updStaff(staff.getStaffAcc(),staff.getStaffPwd(),staff.getRoleId()+"",staff.getStaffName(),staff.getStaffAdd(),staff.getStaffId()+"");
        /*if (re!=0){
            return "success";
        }*/
        return "fail";
    }

    @RequestMapping("/text")
    public String text(){
        return "text";
    }
}
