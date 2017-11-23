package com.matrix.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matrix.entity.SysUser;
import com.matrix.service.SysUserServiceI;

@Controller
public class SysUserController {

	@Resource
	SysUserServiceI service;
	
	@RequestMapping("/mybatis/all")
	public void mybatisselectAll(){
		List<SysUser> userList = service.selectAllWithMybatis();
		for (SysUser sysUser : userList) {
			System.out.println(sysUser.toString());
		}
	}
	
	@RequestMapping("/mybatis/select/{id}")
	public void mybatisselect(@PathVariable Integer id){
		SysUser user = service.selectByIdWithMybatis(id);
		if (user != null) {
			System.out.println(user.toString());
		}else {
			System.out.println("not found ");
		}
	}	
	
	@RequestMapping("/mybatis/delete/{id}")
	public void mybatisdelete(@PathVariable Integer id){
		//service.deleteByIdWithMybatis(id);
		System.out.println("jdbc delete success");
	}	
	
	@RequestMapping("/mybatis/save")
	public void mybatissave(@RequestParam String uName , @RequestParam Integer uAge ){
		service.saveWithMybatis(uName, uAge);
		System.out.println("jdbc save success");
	}	
}
