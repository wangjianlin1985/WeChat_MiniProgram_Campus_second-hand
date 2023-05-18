package com.zjj.miniwechat.service;

import java.util.List;

import com.zjj.miniwechat.entity.Goods;
import com.zjj.miniwechat.vo.VGoods;

/**
 * @author 张建军
 *
 * 2019年5月5日下午7:43:40
 */
public interface GoodsService {
	/**
	 * @return
	 */
	public List<VGoods> findAll();
	
	/**
	 * @param gid
	 * @return
	 */
	public Goods findOne(int gid);
	

	/**
	 * @param goods
	 */
	public void addGoods(Goods goods);
	
	/**查找某个用户发布的商品
	 * @param uid
	 * @return
	 */
	public List<Goods> findGoodsByUid(int uid);
	
	/**
	 * @return
	 */
	public List<Goods> findAllGoods();
	
	public void deleteGoodsById(int id);
	
	public List<VGoods> findGoodByName(String goodName);
	
	/**发货
	 * @param gid
	 */
	public void shipmentsGoods(int gid);
}
