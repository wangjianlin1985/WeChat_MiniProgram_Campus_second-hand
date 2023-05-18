package com.zjj.miniwechat.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zjj.miniwechat.dao.UserDao;
import com.zjj.miniwechat.entity.User;
import com.zjj.miniwechat.utils.JdbcUtils;

/**
 * @author 张建军
 *
 * 2019年5月4日上午10:04:37
 */
public class UserDaoImpl implements UserDao{

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.UserDao#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String uname) {
		// TODO Auto-generated method stub
		String sql = "select * from t_user where username=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		User user = null;
		try {
			user = qr.query(sql, new BeanHandler<>(User.class),uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.UserDao#addUser(com.zjj.miniwechat.entity.User)
	 */
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user values(null, ?, ?, 0)";
		Object[] args = {user.getUsername(), user.getPassword()};
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			qr.update(sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.UserDao#findAll()
	 */
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from t_user";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<User> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.UserDao#selectUser()
	 */
	@Override
	public List<User> selectUser(String username, int roleId) {
		// TODO Auto-generated method stub
		//模糊查询
		String sql = "select * from t_user where 1=1 ";
		List<Object> list = new ArrayList<>();
		if(username != null && !username.isEmpty()){
			sql += "and username like ? ";
			list.add("%" + username + "%");
		}
		if(1 == roleId || 0 == roleId){
			sql += "and uroleId=?";
			list.add(roleId);
		}
		
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<User> uList = null;
		try {
			uList = qr.query(sql, new BeanListHandler<>(User.class), list.toArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uList;
	
	}
	


}
