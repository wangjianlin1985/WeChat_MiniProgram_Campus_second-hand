package com.zjj.miniwechat.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zjj.miniwechat.dao.GoodsDao;
import com.zjj.miniwechat.entity.Goods;
import com.zjj.miniwechat.utils.JdbcUtils;
import com.zjj.miniwechat.vo.VGoods;

/**
 * @author 张建军
 *
 * 2019年5月5日下午7:40:11
 */
public class GoodDaoImpl implements GoodsDao{

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.GoodsDao#findAll()
	 */
	@Override
	public List<VGoods> findAll() {
		// TODO Auto-generated method stub
		String sql = "select gid,gname, gimage, gprice from t_goods";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<VGoods> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(VGoods.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.GoodsDao#findOne(int)
	 */
	@Override
	public Goods findOne(int gid) {
		// TODO Auto-generated method stub
		String sql ="select *  from t_goods where gid = ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Goods goods = null;
		try {
			goods = qr.query(sql, new BeanHandler<>(Goods.class),gid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.GoodsDao#addGoods(com.zjj.miniwechat.entity.Goods)
	 */
	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		String sql = "insert into t_goods values(null,?, ?, ?, ?, ?, ?,1)";
		
		Object[] args = {
			goods.getGname(),
			goods.getGimage(),
			goods.getGdesc(),
			goods.getGnum(),
			goods.getGprice(),
			goods.getUid()
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
	 * @see com.zjj.miniwechat.dao.GoodsDao#findGoodsByUid(int)
	 */
	@Override
	public List<Goods> findGoodsByUid(int uid) {
		// TODO Auto-generated method stub
		String sql = "select * from t_goods where uid = ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Goods> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Goods.class), uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.GoodsDao#findAllGoods()
	 */
	@Override
	public List<Goods> findAllGoods() {
		// TODO Auto-generated method stub
		String sql = "select * from t_goods";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Goods> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Goods.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.GoodsDao#deleteGoodsById(int)
	 */
	@Override
	public void deleteGoodsById(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_goods where gid=? ";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.GoodsDao#findGoodByName(java.lang.String)
	 */
	@Override
	public List<VGoods> findGoodByName(String goodName) {
		// TODO Auto-generated method stub
		String sql = "select * from t_goods where gname like ? ";
		
		Object[] args = {"%" + goodName+ "%"};
		
		QueryRunner qr = JdbcUtils.getQueryRunner();
		
		List<VGoods> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(VGoods.class),args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.GoodsDao#shipmentsGoods(int)
	 */
	@Override
	public void shipmentsGoods(int gid) {
		// TODO Auto-generated method stub
		String sql = "update t_goods set gstate=3 where gid = ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			qr.update(sql,gid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
