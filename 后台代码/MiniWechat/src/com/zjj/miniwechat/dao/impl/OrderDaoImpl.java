package com.zjj.miniwechat.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zjj.miniwechat.dao.OrderDao;
import com.zjj.miniwechat.entity.Order;
import com.zjj.miniwechat.utils.JdbcUtils;
import com.zjj.miniwechat.vo.VOrders;

/**
 * @author 张建军
 *
 * 2019年5月10日下午7:31:22
 */
public class OrderDaoImpl implements OrderDao{

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.OrderDao#addOrder(com.zjj.miniwechat.entity.Order)
	 */
	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		String sql  = "insert into t_order values(null, ?, ?, ?, ?, ?, ?)";
		Object[] args =  {
				order.getPrice(),
				order.getCreatetime(),
				order.getUid(),
				order.getAid(),
				order.getGid(),
				order.getGstatus()
		};
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			qr.update(sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.OrderDao#findAll(com.zjj.miniwechat.entity.Order)
	 */
	@Override
	public List<VOrders> findAll(int uid, int gstatus) {
		// TODO Auto-generated method stub
		String sql = "select o.*, g.gimage, g.gname from t_order o\r\n" + 
				"inner join t_goods g\r\n" + 
				"on o.gid = g.gid\r\n" + 
				"where o.uid = ? " ;
		
		if (0 == gstatus) {
			sql  += "and gstatus = 0";		//查找代发货的商品
		}
		
		if (1 == gstatus) {
			sql += " and gstatus = 1";		//查找带收货单的商品
		}
		
		if (3 == gstatus) {
			sql += "";					//查找买过的商品
		}

		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<VOrders> list = null;
		try {
			list= qr.query(sql, new BeanListHandler<>(VOrders.class), uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.OrderDao#findAllOrder()
	 */
	@Override
	public List<VOrders> findAllOrder() {
		// TODO Auto-generated method stub
		
		String sql = "select o.*, u.username from t_order o\r\n" + 
				"inner join t_user u\r\n" + 
				"on o.uid=u.uid;";
		
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<VOrders> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(VOrders.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.OrderDao#findOrderBySomeThings(java.lang.String, int)
	 */
	@Override
	public List<VOrders> findOrderBySomeThings(String name, int type) {
		// TODO Auto-generated method stub
		String sql = "select o.*, u.username from t_order o\r\n" + 
				"inner join t_user u\r\n" + 
				"on o.uid=u.uid where 1=1 ";
		
		List<Object> list = new ArrayList<>();
		if (name != null && !name.isEmpty()) {
			sql += "and u.username like ? ";
			list.add("%" + name + "%");
		}
		
		if (type == 1 || type == 2 || type == 3) {
			sql += "and o.gstatus=? ";
			type = type - 1;
			list.add(type);
		}
		
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<VOrders> olist = null;
		try {
			olist= qr.query(sql, new BeanListHandler<>(VOrders.class), list.toArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return olist;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.OrderDao#shipmentsGoods(int)
	 */
	@Override
	public void shipmentsGoods(int oid) {
		// TODO Auto-generated method stub
		String sql = "update t_order set gstatus=1 where oid = ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			qr.update(sql,oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.OrderDao#updateOrderByGid(int)
	 */
	@Override
	public void updateOrderByGid(int gid) {
		// TODO Auto-generated method stub
		String sql  = "update t_order set gstatus=1 where gid = ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			qr.update(sql,gid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
