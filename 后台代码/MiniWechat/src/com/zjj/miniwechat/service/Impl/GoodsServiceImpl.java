package com.zjj.miniwechat.service.Impl;

import java.util.List;

import com.zjj.miniwechat.dao.GoodsDao;
import com.zjj.miniwechat.dao.impl.GoodDaoImpl;
import com.zjj.miniwechat.entity.Goods;
import com.zjj.miniwechat.service.GoodsService;
import com.zjj.miniwechat.vo.VGoods;

/**
 * @author 张建军
 *
 * 2019年5月5日下午7:44:12
 */
public class GoodsServiceImpl implements GoodsService{

	
	private GoodsDao goodsDao = new GoodDaoImpl();
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.GoodsService#findAll()
	 */
	@Override
	public List<VGoods> findAll() {
		// TODO Auto-generated method stub
		List<VGoods> list = goodsDao.findAll();
		return list;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.GoodsService#findOne(int)
	 */
	@Override
	public Goods findOne(int gid) {
		// TODO Auto-generated method stub
		Goods goods = goodsDao.findOne(gid);
		return goods;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.GoodsService#addGoods(com.zjj.miniwechat.entity.Goods)
	 */
	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.addGoods(goods);
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.GoodsService#findGoodsByUid(int)
	 */
	@Override
	public List<Goods> findGoodsByUid(int uid) {
		// TODO Auto-generated method stub
		List<Goods> list = goodsDao.findGoodsByUid(uid);
		return list;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.GoodsService#findAllGoods()
	 */
	@Override
	public List<Goods> findAllGoods() {
		// TODO Auto-generated method stub
		List<Goods> list = goodsDao.findAllGoods();
		return list;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.GoodsService#deleteGoodsById(int)
	 */
	@Override
	public void deleteGoodsById(int id) {
		// TODO Auto-generated method stub
		goodsDao.deleteGoodsById(id);
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.GoodsService#findGoodByName(java.lang.String)
	 */
	@Override
	public List<VGoods> findGoodByName(String goodName) {
		// TODO Auto-generated method stub
		return goodsDao.findGoodByName(goodName);
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.GoodsService#shipmentsGoods(int)
	 */
	@Override
	public void shipmentsGoods(int gid) {
		// TODO Auto-generated method stub
		goodsDao.shipmentsGoods(gid);
	}

}
