package com.jin.jin.controller;

import com.jin.jin.model.ResponseBo;
import com.jin.jin.model.User;
import com.jin.jin.service.UserService;
import com.jin.jin.util.MD5Utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class LoginController {
    @Autowired
    public UserService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login1");
        return mav;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(String username, String password, Boolean rememberMe,HttpServletRequest req) {
        // 密码MD5加密
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password,rememberMe);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ResponseBo.ok();
        } catch (UnknownAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResponseBo.error(e.getMessage());
        } catch (LockedAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败！");
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index1";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }

    @GetMapping("/regiest")
    public String regiest(Model model) {
        return "register";
    }

    @PostMapping("/regiest")
    @ResponseBody
    public ResponseBo regiest(User user,HttpServletRequest request,HttpServletResponse response){
        String userName = user.getUserName();//用户名唯一
        User usercheck = new User();
        usercheck = userService.findByUserName(userName);
        if(usercheck!=null){
            return ResponseBo.error(3,"已经有此用户");
        }else{
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            user.setPassword(MD5Utils.encrypt(user.getUserName(), user.getPassword()));
            user.setCreateTime(dateFormat.format(date));
            user.setStatus(1);
            user.setUserid(UUID.randomUUID().toString().replace("-", ""));
            int count = userService.addUser(user);
            if(count>0){
                return ResponseBo.ok();
            }else {
                return ResponseBo.error(1,"添加用户异常");
            }
        }
    }

}