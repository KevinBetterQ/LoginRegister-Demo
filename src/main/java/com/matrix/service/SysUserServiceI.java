package com.matrix.service;

import java.util.List;

import com.matrix.entity.SysUser;

public interface SysUserServiceI {

	public void saveWithMybatis(String uName, int uAge );
	public SysUser selectByIdWithMybatis(int uId );
	public List<SysUser> selectAllWithMybatis();
	public void deleteByIdWithMybatis(int uId );
}
