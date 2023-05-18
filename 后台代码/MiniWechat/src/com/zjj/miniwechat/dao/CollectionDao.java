package com.zjj.miniwechat.dao;


import java.util.List;

import com.zjj.miniwechat.entity.Collection;
import com.zjj.miniwechat.vo.VCollection;

/**
 * @author 张建军
 *
 * 2019年5月6日下午8:58:20
 */
public interface CollectionDao {
	/**
	 * @param collection
	 */
	public void addCollection(Collection collection);
	
	/**
	 * @param uid
	 * @return
	 */
	public List<VCollection> findByUid(int uid);
	
	public void removeCollection(int cid);
}
