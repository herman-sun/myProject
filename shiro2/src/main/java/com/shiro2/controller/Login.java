package com.shiro2.controller;


import com.shiro2.entity.Userinfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Login {
    @PostMapping("/login")
    public String login(Userinfo info, ModelMap map){
        System.out.println(info);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(info.getUname(), info.getUpass());



        try {
            subject.login(token);
            return "redirect:/admin/index.jsp";
        }catch (UnknownAccountException ae) {
            map.put("error","没有当前账户");
            return "/index";
        }catch (IncorrectCredentialsException ae) {
            map.put("error","密码不正确");
            return "/index";
        } catch (Exception ae) {
            map.put("error","登录失败：" + ae);
            return "/index";
        }
    }

    @GetMapping("/admin/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//session.invaliate();
        return "redirect:/toindex.jsp";
    }
}
