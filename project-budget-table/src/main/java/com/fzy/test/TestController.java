package com.fzy.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller						//Controller注解
public class TestController {

	/*
	 * 测试spring boot基础环境
	 */
	@RequestMapping("/hello")		//访问地址url
	@ResponseBody					//响应体 ——return "success";
	public String hello() {
		System.out.println("test------");
		return "success";			//若无@ResponseBody响应体注解，此return的字符串（加/）为：资源路径   success.html
	}
	
	/*
	 * 测试thymeleaf页面模块是否可用
	 */
	@RequestMapping("/testThymeleaf")
	public String testThymeleaf(Model model) {
		//把数据存入model中
		model.addAttribute("test", "thymeleaf");
		//返回test.html     （return "test";)与return的值一致
		return "test";
	}
	
	
	//add.html用户添加
	@RequestMapping("/add")
	public String add() {
		return "/user/add";
	}
	//update.html用户更新
	@RequestMapping("/update")
	public String update() {
		return "/user/update";
	}
	//login.html自定义的登录页面
	@RequestMapping("/toLogin")
	public String login() {
		return "/login";
	}
	
	
	/*
	 * 登录逻辑处理
	 */
	@RequestMapping("/login")
	public String login(String name,String password,Model model) {		//name和password也可以封装到一个user对象中,model用来存放一些需要携带的信息
		System.out.println("name="+name);
		/*
		 * 使用Shiro编写认证操作
		 * 1.获取Subject
		 * 2.封装用户数据
		 * 3、执行登录方法
		 */
		//1.获取Subject
		Subject subject = SecurityUtils.getSubject();
		//2.封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
		//3.执行登录方法
		try {
			subject.login(token);			//shiro会把流程交给Realm，执行login方法会去往Realm的执行认证逻辑方法
			/*
			 * 无任何异常，则登录成功
			 * 跳转到test.html页面
			 */
//			return "redirect:/testThymeleaf";		//redirect：重定向（不带数据），而非转发请求（带数据）
			return "redirect:/index";
		} catch (UnknownAccountException e) {
			//UnKnownAccountException登录失败：用户名不存在
			model.addAttribute("msg", "用户名不存在");
			//带着msg数据，转发请求
			return "login";
		} catch (IncorrectCredentialsException e) {
			//IncorrectCredentialsException登录失败：密码错误
			model.addAttribute("msg", "密码错误");
			return "login";
		}
	}
	
	
	//noAuth.html——未授权提示页面
	@RequestMapping("noAuth")
	public String noAuth() {
		return "/noAuth";
	}
	
	/*
	 * 服务项目预算表
	 */
//	@RequestMapping("/index")
//	public String index() {
//		return "/index";
//	}
	
	
}
