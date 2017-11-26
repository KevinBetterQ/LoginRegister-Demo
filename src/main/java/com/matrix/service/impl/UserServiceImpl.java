package com.matrix.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.dao.UserDao;
import com.matrix.entity.User;
import com.matrix.service.UserService;
import com.sun.org.apache.bcel.internal.generic.RETURN;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	UserDao userDao;
	
	@Override
	public boolean deleteUser(String uid) {
		return userDao.deleteUser(uid);
	}

	//用户注册服务
	@Override
	public String insertUser(User user) {
		
		user.setUrole(0);
		user.setUscore(0);
		
		List<User> users = userDao.queryById(user.getUid());
		System.out.println("查询完成……");
		if(!users.isEmpty())
			return "用户名已存在";
		else{
			if(userDao.insertUser(user)) return "注册成功";
			else return "register error";
		}
	}

	@Override
	public List<User> queryById(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUidAvailable(String uid) {
		return userDao.queryById(uid).isEmpty();
	}

}
