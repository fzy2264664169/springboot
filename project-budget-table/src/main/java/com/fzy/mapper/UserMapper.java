package com.fzy.mapper;

import com.fzy.domain.User;

public interface UserMapper {

	public User findUserByName(String name);
	
	public User findUserById(Integer id);
}
