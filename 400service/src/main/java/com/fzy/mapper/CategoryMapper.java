package com.fzy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fzy.domain.Category;

@Mapper						//表示这是一个Mybatis mapper接口
public interface CategoryMapper {

	@Select("select * from category_ ")	//表示调用findAll方法会执行对应的sql语句
	List<Category> findAll();
	
	@Insert(" insert into category_ ( name ) values (#{name}) ")
    public int save(Category category); 
     
    @Delete(" delete from category_ where id= #{id} ")
    public void delete(int id);
         
    @Update("update category_ set name=#{name} where id=#{id} ")
    public int update(Category category);
    
    @Select("select * from category_ where id= #{id} ")
    public Category get(int id);
    
    /*
     * JPA条件查询
     * JPA 条件查询方式很有意思，是不需要写 SQL 语句的，
     * 只需要在 dao 接口里按照规范的命名定义对应的方法名，
     * 即可达到查询相应字段的效果了
     */
    public List<Category> findByName(String name);
    public List<Category> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name, int id);
}
