package com.fzy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.domain.User;
import com.fzy.mapper.UserMapper;
import com.fzy.service.UserService;
@Service				//业务实现类注解
public class UserServiceImpl implements UserService {

	//实现类要使用mapper（即dao）接口中的方法，所以要注入mapper接口
	@Autowired
	private UserMapper usermapper;
	
	@Override
	public User findUserByName(String name) {
		//用mapper接口对象，调用mapper接口中的方法
		return usermapper.findUserByName(name);
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return usermapper.findUserById(id);
	}

}
