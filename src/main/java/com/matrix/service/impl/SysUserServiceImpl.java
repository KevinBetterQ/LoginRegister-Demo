package com.matrix.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.dao.SysUserDaoI;
import com.matrix.entity.SysUser;
import com.matrix.service.SysUserServiceI;

@Service
public class SysUserServiceImpl implements SysUserServiceI{

	@Resource
	SysUserDaoI dao;
	
	@Override
	public void saveWithMybatis(String uName, int uAge) {
		SysUser user = new SysUser();
		user.setuName(uName);
		user.setuAge(uAge);
		dao.save(user);
		
	}

	@Override
	public SysUser selectByIdWithMybatis(int uId) {
		
		return dao.selectById(uId);
	}

	@Override
	public List<SysUser> selectAllWithMybatis() {
		
		return dao.selectAll();
	}

	@Override
	public void deleteByIdWithMybatis(int uId) {
		dao.deleteById(uId);
		
	}

	
}
