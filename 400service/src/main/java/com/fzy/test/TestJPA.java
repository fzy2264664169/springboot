package com.fzy.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fzy.Application;
import com.fzy.domain.Category;
import com.fzy.domain.SysUser;
import com.fzy.mapper.CategoryMapper;
import com.fzy.mapper.SysUserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class TestJPA {

	@Autowired CategoryMapper categoryMapper;	//自动装配
	
	@Test
	public void test() {
		List<Category> cs = categoryMapper.findAll();
		for(Category c : cs)
			System.out.println("c.getName():" + c.getName());
	}
	
//	@Before				//测试之前的操作
//	public void before() {
//		List<Category> cs = categoryMapper.findAll();
//		for (Category c : cs) {
//			categoryMapper.delete(c.getId());
//		}
//		
//		for(int i = 0;i < 10;i++) {
//			Category c = new Category();
//			c.setName("category000" + i);
//			categoryMapper.save(c);
//		}
//	}
	
	@Test
	public void test1() {
		List<Category> cs = categoryMapper.findAll();
		System.out.println("所有的分类信息");
		for (Category category : cs) {
			System.out.println(category.getName());
		}
		System.out.println();
	}
	@Test
	public void test2() {
		List<Category> cs = categoryMapper.findByName("category0003");
		System.out.println("查询名称是\"category0003\"的分类：");
		for (Category category : cs) {
			System.out.println("c.getName():" + category.getName());
		}
		System.out.println();
	}
	@Test
    public void test3() {
        System.out.println("根据名称模糊查询，id 大于5, 并且名称正排序查询");
        List<Category> cs=  categoryMapper.findByNameLikeAndIdGreaterThanOrderByNameAsc("%3%",5);
        for (Category c : cs) {
            System.out.println(c);
        }
        System.out.println();
         
    }
	@Autowired SysUserMapper sysUserMapper;
	@Test
	public void test4() {
		System.out.println("sysuser");
		List<SysUser> su = sysUserMapper.findAll();
		System.out.println("sysuser");
		for (SysUser sysUser : su) {
			System.out.println(sysUser.getUserName());
			System.out.println(sysUser.getUserStatus());
			System.out.println("1234567");
		}
		System.out.println("successsssssss");
//		SysUser sUser = sysUserMapper.findUserByName("fzy");
//		System.out.println(sUser.getPassword());
	}
}
