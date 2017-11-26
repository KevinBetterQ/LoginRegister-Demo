package com.matrix.service;

import java.util.List;

import com.matrix.entity.User;

public interface UserService {

	
	public String insertUser(User user);
	public boolean deleteUser(String uid);
	public List<User> queryById(String uid);
	public List<User> queryAll();
	
	public boolean checkUidAvailable(String uid);
}
