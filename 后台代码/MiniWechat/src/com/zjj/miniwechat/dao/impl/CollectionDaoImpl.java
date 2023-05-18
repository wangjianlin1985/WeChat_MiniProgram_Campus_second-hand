package com.zjj.miniwechat.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zjj.miniwechat.dao.CollectionDao;
import com.zjj.miniwechat.entity.Collection;
import com.zjj.miniwechat.utils.JdbcUtils;
import com.zjj.miniwechat.vo.VCollection;

/**
 * @author 张建军
 *
 * 2019年5月6日下午8:59:39
 */
public class CollectionDaoImpl implements CollectionDao{

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.CollectionDao#addCollection(com.zjj.miniwechat.entity.Collection)
	 */
	@Override
	public void addCollection(Collection collection) {
		// TODO Auto-generated method stub
		String sql = "insert into t_collection values(null, ?, ?,0)";
		Object[] args = {collection.getGid(), collection.getUid()};
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			qr.update(sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.CollectionDao#findByUid(int)
	 */
	@Override
	public List<VCollection> findByUid(int uid) {
		// TODO Auto-generated method stub
		String sql = "select c.cid,g.gimage,g.gname,g.gprice ,c.isselect,c.uid from t_collection c\r\n" + 
				"inner join t_goods  g\r\n" + 
				"on g.gid=c.gid\r\n" + 
				"where c.uid = ?";
		
		QueryRunner qr = JdbcUtils.getQueryRunner();
		
		List<VCollection> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(VCollection.class),uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.dao.CollectionDao#removeCollection(int)
	 */
	@Override
	public void removeCollection(int cid) {
		// TODO Auto-generated method stub
		String sql = "delete from t_collection where cid = ?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			qr.update(sql, cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
