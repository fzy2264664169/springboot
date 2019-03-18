package com.fzy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.fzy.domain.SysUser;


public interface SysUserMapper {

	public SysUser findSysUserById(Integer id);
	
	public SysUser findUserByName(String name);
	
	List<SysUser> findAll();
}

//注解开发
/*@Mapper
public interface SysUserMapper {

	@Select("select * from ht_sys_user Where user_id = ${value}")
	public SysUser findSysUserById(Integer id);
	
	@Select("select * from ht_sys_user where user_name = #{value}")
	public SysUser findUserByName(String name);
	
	@Select("select user_name userName,user_password userPassword from ht_sys_user")
	List<SysUser> findAll();
}*/
