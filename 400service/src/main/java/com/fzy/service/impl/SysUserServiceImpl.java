package com.fzy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.domain.SysUser;
import com.fzy.mapper.SysUserMapper;
import com.fzy.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired SysUserMapper sysUserMapper;
	@Override
	public SysUser findSysUserById(Integer id) {
		// TODO Auto-generated method stub
		return sysUserMapper.findSysUserById(id);
	}
	@Override
	public SysUser findUserByName(String name) {
		// TODO Auto-generated method stub
		return sysUserMapper.findUserByName(name);
	}

}
