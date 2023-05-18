package com.zjj.miniwechat.service;

import java.util.List;

import com.zjj.miniwechat.entity.Collection;
import com.zjj.miniwechat.vo.VCollection;

/**
 * @author 张建军
 *
 * 2019年5月6日下午9:02:23
 */
public interface CollectionService {
	/**
	 * @param collection
	 */
	public void addCollection(Collection collection);
	
	/**
	 * @param uid
	 * @return
	 */
	public List<VCollection> findByUid(int uid);
	
	/**
	 * @param cid
	 */
	public void removeCollection(int cid);
}
