package com.fzy.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.fzy.domain.SysUser;
import com.fzy.domain.User;
import com.fzy.service.SysUserService;
import com.fzy.service.UserService;
/**
 * 自定义realm
 * @author fzywhy
 *
 */
public class TestRealm extends AuthorizingRealm {

	/*
	 * 执行授权逻辑
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("执行授权逻辑");
//		
//		/*
//		 * 给资源进行授权
//		 */
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		//添加资源的授权字符串
////		info.addStringPermission("user:add");	//参数字符串与资源授权过滤器的参数值一致
//		
//		/*
//		 * 改造授权字符串硬编码
//		 * 到数据库中查询当前登录用户的授权字符串
//		 */
//		//获取当前用户
//		Subject subject = SecurityUtils.getSubject();
//		//获取执行认证返回的principal的参数			//执行认证逻辑时判断密码返回的第一个参数user
//		User user = (User)subject.getPrincipal();
//		//得到user的id
//		User userId = userService.findUserById(user.getId());
//		//获取当前用户数据库中给定的授权字符串,并将其添加为资源的授权字符串
//		info.addStringPermission(userId.getPerms());
//		System.out.println(userId.getPerms());
//		return info;
		
		return null;
	}


	//需要调用业务层service接口中的方法得到页面中的数据，注入UserService
	@Autowired
//	private UserService userService;
	private SysUserService sysUserService;
	
	/*
	 * 执行认证逻辑
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		
//		/*
//		 * 认证逻辑
//		 */
//		//给定用户名和密码
//		String name = "fzy";
//		String password = "fzy";
//		/*
//		 * 编写shiro的判断逻辑，判断用户名和密码
//		 */
//		//1.判断用户名
//		UsernamePasswordToken token = (UsernamePasswordToken)arg0;		//将形参强制转换为TestController.java中封装的数据类型，即controller中传递来的数据
//		//如果用户名不存在
//		if(!token.getUsername().equals(name)) {
//			return null;		//shiro底层会抛出UnknownAccountException
//		}
//		//2.判断密码 		返回返回类型AuthenticationInfo的一个子类SimpleAuthenticationInfo（参数1：需要返回给login方法的数据，参数2：数据库密码，参数3：shiro名字）
//		return new SimpleAuthenticationInfo("", password, "");
		
		/*
		 * 与mybatis整合后的认证逻辑
		 */
		//判断用户名
		UsernamePasswordToken token = (UsernamePasswordToken)arg0;
		//得到用户在页面上填写的用户名
//		User user = userService.findUserByName(token.getUsername());
		SysUser user = sysUserService.findUserByName(token.getUsername());
		System.out.println(token.getUsername());
		//如果用户名不存在
		if(user == null) {
			return null;				//shiro底层抛出UnknownAccountException
		}
		//判断密码		返回返回类型AuthenticationInfo的一个子类SimpleAuthenticationInfo（参数1：需要返回给login方法的数据，参数2：数据库密码，参数3：shiro名字）
//		System.out.println(user.getUserPassword());
		
//		return new SimpleAuthenticationInfo(user, user.getUserPassword(), "");
		return new SimpleAuthenticationInfo(user, user.getUserPassword(), "");

	}


	
}
