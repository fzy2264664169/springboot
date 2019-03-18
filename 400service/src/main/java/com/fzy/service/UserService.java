package com.fzy.service;
 
import com.fzy.domain.User;
 
public interface UserService {
	public User findUserByName(String name);
	public User findUserById(Integer id);
}
