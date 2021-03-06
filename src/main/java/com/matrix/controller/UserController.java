package com.matrix.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matrix.entity.User;
import com.matrix.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Resource
	UserServiceImpl userService;
	@Resource
	User user;
	
	//登录验证
	@RequestMapping("/login")
	public void loginUser(@RequestParam("uid") String uid, @RequestParam("passwd") String passwd, HttpSession session, HttpServletResponse response) {
        System.out.println("/login");
		try {
            User user = userService.checkLogin(uid, passwd);
            if (null != user) {
                session.setAttribute("user", user);
                response.getWriter().print("true");
            } else {
                response.getWriter().print("false");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	//用户退出
	@RequestMapping("/logout")
	public String LogOutputStream(ModelMap model, HttpSession session){
		session.removeAttribute("user");
		User user = (User) session.getAttribute("user");
        if (null == user) {
            model.addAttribute("info", "#login");
            model.addAttribute("uname", "登录");
        }
        return "index";
	}
	
	//用户注册界面
	@RequestMapping("/register")
	 public String register(ModelMap model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (null == user) {
            model.addAttribute("info", "#login");
            model.addAttribute("uname", "登录");
        } else {
            model.addAttribute("info", "#");
            model.addAttribute("uname", user.getUname());
        }
        return "register";
    }
	
	@RequestMapping("/userRegister")
	public void registerUser(HttpServletRequest req, HttpServletResponse response){
		System.out.println("/userRegister");
		user.setUid(req.getParameter("uid"));
		user.setUemail(req.getParameter("uemail"));
		user.setPasswd(req.getParameter("passwd"));
		user.setUname(req.getParameter("uname"));
		user.setUclass(req.getParameter("uclass"));
		user.setUphone(req.getParameter("uphone"));
		try {
			response.getWriter().print(userService.insertUser(user));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//检查用户是否存在
	@RequestMapping("/checkUIDAvailable")
	public void checkUIDAvailable(String uid, HttpServletResponse response) {
        try {
            response.getWriter().print(userService.checkUidAvailable(uid) ? "true" : "用户名已存在");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
