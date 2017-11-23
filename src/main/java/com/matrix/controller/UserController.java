package com.matrix.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matrix.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Resource
	UserServiceImpl userService;
	
	@RequestMapping("/user/delete/{uid}")
	public void delete(@PathVariable String uid){
		System.out.println("/user/delete");
		if(userService.deleteUser(uid)==true)
			System.out.println("delete success");
		else System.out.println("delete faild");
	}
	
	@RequestMapping("/user/test")
	public void hello(@PathVariable String uid){
		System.out.println("/user/testsuce");
		
	}
	
	
}
