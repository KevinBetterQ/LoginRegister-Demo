package com.matrix.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matrix.entity.User;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value = "")
	public String index(ModelMap model, HttpSession session) {
		System.out.println("index");
		User user = (User) session.getAttribute("user");
		if (null == user) {
			model.addAttribute("info", "#login");
			model.addAttribute("uname", "登录");
		} else {
			model.addAttribute("info", "#");
			model.addAttribute("uname", user.getUname());
		}
		return "index";

	}

}
