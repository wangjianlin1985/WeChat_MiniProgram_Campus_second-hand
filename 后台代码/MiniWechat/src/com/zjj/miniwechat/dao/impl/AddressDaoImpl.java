package com.zjj.miniwechat.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zjj.miniwechat.dao.AddressDao;
import com.zjj.miniwechat.entity.Address;
import com.zjj.miniwechat.utils.JdbcUtils;

/**
 * @author 张建军
 *
 * 2019年5月7日下午7:26:44
 */
public class AddressDaoImpl implements AddressDao {

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.AddressDao#findAddressById(int)
	 */
	@Override
	public List<Address> findAddressById(int uid) {
		// TODO Auto-generated method stub
		String sql = "select * from t_address where uid = ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Address> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Address.class),uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.AddressDao#deleteAddress(int)
	 */
	@Override
	public void deleteAddress(int aid) {
		// TODO Auto-generated method stub
		String sql = "delete from t_address where aid =  ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			qr.update(sql, aid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.AddressDao#findOneAddress(int)
	 */
	@Override
	public Address findOneAddress(int aid) {
		// TODO Auto-generated method stub
		String sql = "select * from t_address where aid = ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Address address = null;
		try {
			address = qr.query(sql, new BeanHandler<>(Address.class),aid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return address;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.AddressDao#addAddress(com.zjj.miniwechat.entity.Address)
	 */
	@Override
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		String sql  = "insert into t_address values(null, ? , ?, ?)";
		Object[] args = {
				address.getTel(),
				address.getAddress(),
				address.getUid()
		};
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			qr.update(sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
