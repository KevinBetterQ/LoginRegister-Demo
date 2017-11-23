package com.matrix.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.dao.UserDao;
import com.matrix.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	UserDao userDao;
	
	@Override
	public boolean deleteUser(String uid) {
		return userDao.deleteUser(uid);
	}

}
