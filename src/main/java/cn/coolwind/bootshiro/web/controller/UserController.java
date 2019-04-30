package cn.coolwind.bootshiro.web.controller;

import cn.coolwind.bootshiro.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Object log(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        String msg = "登录成功";
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            msg = "IncorrectCredentialsException -- > 密码不正确：";
        } catch (UnknownAccountException e) {
            msg = "UnknownAccountException -- > 账号不存在：";
        } catch (Exception e) {
            msg = "其他错误";
        }
        log.info("/login------>"+msg);
        return msg;
    }

    @GetMapping("/change")
    public Object change() {
        userService.changeRolePermission(3,new Integer[]{1,2,3});
        return "ok!";
    }
    @GetMapping("/403")
    public Object forbidden() {
        return "没有权限！";
    }
}
