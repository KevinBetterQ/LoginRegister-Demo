package com.matrix.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.matrix.entity.User;

@Repository
public interface UserDao {
	public boolean insertUser(User user);
	public boolean deleteUser(String uid);
	public List<User> queryById(String uid);
	public List<User> queryAll();
	public List<User> queryIdPasswd(String uid, String passwd);
}
