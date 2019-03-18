package com.fzy.mapper;
 
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.fzy.domain.User;

/*
 * 若使用mybatis注解方式需添加：
 * 		@Mapper注解和@Select注解
 * 同时在对应目录下不可有与此mapper接口对应的mapper.xml文件
 */
@Mapper
public interface UserMapper {
 
	@Select("select * from user where name = #{value}")
	public User findUserByName(String name);
	
	@Select("select * from user where id = #{value}")
	public User findUserById(Integer id);
}
