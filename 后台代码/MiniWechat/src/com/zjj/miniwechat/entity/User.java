package com.zjj.miniwechat.entity;

/**
 * @author 张建军
 *
 * 2019年5月4日上午10:14:31
 */
public class User {
	private Integer uid;
	private String username;
	private String password;
	private  int uroleId;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUroleId() {
		return uroleId;
	}
	public void setUroleId(int uroleId) {
		this.uroleId = uroleId;
	}
	
	
}
