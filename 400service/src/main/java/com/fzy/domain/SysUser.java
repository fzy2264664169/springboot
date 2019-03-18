package com.fzy.domain;
/**
 * table=ht_sys_user
 * @author fzywhy
 *
 */
public class SysUser {

	private Integer userId;
	private String userName;
	private String UserPassword;
	private Integer userStatus;
	
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", userName=" + userName + ", UserPassword=" + UserPassword + "]";
	}
	
}
