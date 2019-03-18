package com.fzy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysUserController {

	/*
	 * 测试shiro内置拦截器——拦截成功跳转至自定义的tologin路径,链接至login.html页面
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	
	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		//把数据存入model中
		model.addAttribute("test", "thymeleaf");
		//返回thymeleaf.html     （return "test";)与return的值一致
		return "thymeleaf";
	}
	
	/*
	 * 登录逻辑处理
	 */
	@RequestMapping("/login")
	public String login(String name,String password,Model model) {		//name和password也可以封装到一个user对象中,model用来返回错误信息
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
		System.out.println(token.getUsername());
		System.out.println(token.getPassword());
		//3.执行登录方法
		try {
			
			subject.login(token);
			System.out.println("successes");
			/*
			 * 无任何异常，则登录成功
			 * 跳转到test.html页面
			 */
			return "redirect:/thymeleaf";		//redirect：重定向（不带数据），而非转发请求（带数据）
		} catch (UnknownAccountException e) {
			System.out.println("failed exception");
			//UnKnownAccountException登录失败：用户名不存在
			model.addAttribute("msg", "用户名不存在");
			//带着msg数据，转发请求
			return "login";
		} catch (IncorrectCredentialsException e) {
			System.out.println("failed password");
			//IncorrectCredentialsException登录失败：密码错误
			model.addAttribute("msg", "密码错误");
			return "login";
		}
	}
}
