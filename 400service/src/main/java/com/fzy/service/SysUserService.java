package com.fzy.service;

import com.fzy.domain.SysUser;

public interface SysUserService {

	public SysUser findSysUserById(Integer id);

	public SysUser findUserByName(String name);
}
