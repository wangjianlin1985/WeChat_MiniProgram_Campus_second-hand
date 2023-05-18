package com.zjj.miniwechat.service.Impl;

import java.util.List;

import com.zjj.miniwechat.dao.OrderDao;
import com.zjj.miniwechat.dao.impl.OrderDaoImpl;
import com.zjj.miniwechat.entity.Order;
import com.zjj.miniwechat.service.OrderService;
import com.zjj.miniwechat.vo.VOrders;

/**
 * @author 张建军
 *
 * 2019年5月10日下午7:36:33
 */
public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao = new OrderDaoImpl();
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.OrderService#addOrder(com.zjj.miniwechat.entity.Order)
	 */
	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		orderDao.addOrder(order);
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.OrderService#findAll(com.zjj.miniwechat.entity.Order)
	 */
	@Override
	public List<VOrders> findAll(int uid, int gstatus) {
		// TODO Auto-generated method stub
		List<VOrders> list = orderDao.findAll(uid, gstatus);
		return list;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.OrderService#findAllOrder()
	 */
	@Override
	public List<VOrders> findAllOrder() {
		// TODO Auto-generated method stub
		List<VOrders> list = orderDao.findAllOrder();
		return list;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.OrderService#findOrderBySomeThings(java.lang.String, int)
	 */
	@Override
	public List<VOrders> findOrderBySomeThings(String name, int type) {
		// TODO Auto-generated method stub
		List<VOrders> list = orderDao.findOrderBySomeThings(name, type);
		return list;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.OrderService#shipmentsGoods(int)
	 */
	@Override
	public void shipmentsGoods(int oid) {
		// TODO Auto-generated method stub
		orderDao.shipmentsGoods(oid);
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.OrderService#updateOrderByGid(int)
	 */
	@Override
	public void updateOrderByGid(int gid) {
		// TODO Auto-generated method stub
		orderDao.updateOrderByGid(gid);
	}
	

}
