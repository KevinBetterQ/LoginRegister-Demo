package com.matrix.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.matrix.entity.SysUser;

@Repository
public interface SysUserDaoI {

	public void save(SysUser user);
	public SysUser selectById(int id);
	public void deleteById(int id);
	public List<SysUser> selectAll();
}
