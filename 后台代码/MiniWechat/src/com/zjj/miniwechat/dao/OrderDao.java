package com.zjj.miniwechat.dao;

import java.util.List;

import com.zjj.miniwechat.entity.Order;
import com.zjj.miniwechat.vo.VOrders;

/**
 * @author 张建军
 *
 * 2019年5月10日下午7:30:27
 */
public interface OrderDao {
	
	/**
	 * @param order
	 */
	public void addOrder(Order order);
	
	/**根据用户名和订单的状态查找相关用户的订单
	 * @param order
	 * @return
	 */
	public List<VOrders> findAll(int uid, int gstatus);
	
	/**查找所有的订单
	 * @return
	 */
	public List<VOrders> findAllOrder();
	
	public List<VOrders> findOrderBySomeThings(String name,int type);
	
	/**发货
	 * @param oid
	 */
	public void shipmentsGoods(int oid);
	
	public void updateOrderByGid(int gid);

}
