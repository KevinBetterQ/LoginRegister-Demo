package com.matrix.service;

import java.util.List;

import com.matrix.entity.User;

public interface UserService {

	
	public String insertUser(User user);
	public boolean deleteUser(String uid);
	public List<User> queryById(String uid);
	public List<User> queryAll();
	
	public boolean checkUidAvailable(String uid);//验证注册id是否存在
	public User checkLogin(String uid, String passwd);//登陆验证
	public User checkLoginConsole(String uid, String passwd);//后台登陆验证
}
