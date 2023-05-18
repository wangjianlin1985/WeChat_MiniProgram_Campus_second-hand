package com.zjj.miniwechat.service.Impl;

import java.util.List;

import com.zjj.miniwechat.dao.CollectionDao;
import com.zjj.miniwechat.dao.impl.CollectionDaoImpl;
import com.zjj.miniwechat.entity.Collection;
import com.zjj.miniwechat.service.CollectionService;
import com.zjj.miniwechat.vo.VCollection;

/**
 * @author 张建军
 *
 * 2019年5月6日下午9:03:22
 */
public class CollectionServiceImpl implements CollectionService{

	
	private CollectionDao collectionDao = new CollectionDaoImpl();
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.CollectionService#addCollection(com.zjj.miniwechat.entity.Collection)
	 */
	@Override
	public void addCollection(Collection collection) {
		// TODO Auto-generated method stub
		collectionDao.addCollection(collection);
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.CollectionService#findByUid(int)
	 */
	@Override
	public List<VCollection> findByUid(int uid) {
		// TODO Auto-generated method stub
		List<VCollection> list = collectionDao.findByUid(uid);
		return list;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.CollectionService#removeCollection(int)
	 */
	@Override
	public void removeCollection(int cid) {
		// TODO Auto-generated method stub
		collectionDao.removeCollection(cid);
	}

}
