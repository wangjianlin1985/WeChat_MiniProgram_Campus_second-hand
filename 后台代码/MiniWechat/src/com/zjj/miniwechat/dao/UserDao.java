package com.zjj.miniwechat.dao;

import java.util.List;

import com.zjj.miniwechat.entity.User;

/**
 * @author 张建军
 *
 * 2019年5月4日上午10:03:07
 */
public interface UserDao {
	/**
	 * @param uname
	 * @return
	 */
	public User findUser(String uname);
	
	
	/**用户注册
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * @return
	 */
	public List<User> findAll();
	
	
	/**根据条件查询用户
	 * @return
	 */
	public List<User> selectUser(String username, int roleId);
}
