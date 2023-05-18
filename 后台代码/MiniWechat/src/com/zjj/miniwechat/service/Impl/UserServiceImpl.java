package com.zjj.miniwechat.service.Impl;

import java.util.List;

import com.zjj.miniwechat.dao.UserDao;
import com.zjj.miniwechat.dao.impl.UserDaoImpl;
import com.zjj.miniwechat.entity.User;
import com.zjj.miniwechat.service.UserService;

/**
 * @author 张建军
 *
 * 2019年5月4日上午10:22:47
 */
public class UserServiceImpl implements UserService{

	
	private UserDao userDao = new UserDaoImpl();
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.UserService#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String uname) {
		// TODO Auto-generated method stub
		User findUser = userDao.findUser(uname);
		
		return findUser;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.UserService#addUser(com.zjj.miniwechat.entity.User)
	 */
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.UserService#findAll()
	 */
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> list = userDao.findAll();
		return list;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.UserService#selectUser(java.lang.String, int)
	 */
	@Override
	public List<User> selectUser(String username, int roleId) {
		// TODO Auto-generated method stub
		List<User> list = userDao.selectUser(username, roleId);
		return list;
	}

}
