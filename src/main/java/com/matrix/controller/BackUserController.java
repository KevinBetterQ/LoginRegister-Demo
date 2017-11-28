package com.matrix.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matrix.entity.User;
import com.matrix.service.impl.UserServiceImpl;

@Controller
public class BackUserController {

	@Resource
	UserServiceImpl userService;
	@Resource
	User user;

	@RequestMapping("/back")
	public String loginConsole() {
		return "back/loginConsole";
	}

	@RequestMapping("/back/checkloginconsole")
	public void loginConsole(@RequestParam("uid") String uid, @RequestParam("passwd") String passwd,
			HttpSession session, HttpServletResponse resp, ModelMap model) throws IOException {
		System.out.println("/back/checkloginconsole");
		User user = userService.checkLoginConsole(uid, passwd);
		if (null != user) {
			model.addAttribute("uname", user.getUname());
			session.setAttribute("user", user);
			resp.getWriter().print("true");
		} else
			resp.getWriter().print("false");

	}

	@RequestMapping("/back/manageuser")
	public String manageUser(ModelMap model, HttpSession session) {
		System.out.println("/back/manageuser");
		model.addAttribute("uname", ((User) session.getAttribute("user")).getUname());
		return "back/manageuser";
	}

	@RequestMapping("/back/getalluser")
	@ResponseBody
	public List<User> getAllUser() {
		System.out.println("/back/getalluser");
		List<User> list = userService.queryAll();
		for (User user : list) {
			user.setPasswd("<button class=\"btn btn-default\" onclick=\"editUser('" + user.getUid()
					+ "')\"><i class=\"glyphicon glyphicon-pencil\"></i></button><button class=\"btn btn-default\" onclick=\"deleteUser('"
					+ user.getUid() + "')\"><i class=\"glyphicon glyphicon-trash\"></i></button>");
		}
		return list;
	}

	@RequestMapping("/back/deleteuser")
	public void deleteUser(String uid, HttpServletResponse resp) throws IOException {
		System.out.println("/back/deleteuser");
		if (uid.equals("admin"))
			resp.getWriter().print("管理员不可删");
		resp.getWriter().print(userService.deleteUser(uid) ? "删除成功" : "删除失败");
	}

	@RequestMapping("/back/updateuser")
	public void updateUser(String uid, HttpServletResponse resp) throws IOException {
		System.out.println("/back/updateuser");
		resp.getWriter().print("更新成功");
	}

}
