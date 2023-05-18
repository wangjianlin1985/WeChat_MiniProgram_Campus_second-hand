package com.zjj.miniwechat.service.Impl;

import java.util.List;

import com.zjj.miniwechat.dao.AddressDao;
import com.zjj.miniwechat.dao.impl.AddressDaoImpl;
import com.zjj.miniwechat.entity.Address;
import com.zjj.miniwechat.service.AddressService;

/**
 * @author 张建军
 *
 * 2019年5月7日下午7:29:43
 */
public class AddressServiceImpl implements AddressService{
	
	
	private AddressDao addressDao = new AddressDaoImpl();
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.AddressService#findAddressById(int)
	 */
	@Override
	public List<Address> findAddressById(int uid) {
		// TODO Auto-generated method stub
		List<Address> list = addressDao.findAddressById(uid);
		return list;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.AddressService#deleteAddress(int)
	 */
	@Override
	public void deleteAddress(int aid) {
		// TODO Auto-generated method stub
		addressDao.deleteAddress(aid);
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.AddressService#findOneAddress(int)
	 */
	@Override
	public Address findOneAddress(int aid) {
		// TODO Auto-generated method stub
		Address address = addressDao.findOneAddress(aid);
		return address;
	}
	/** (non-Javadoc)
	 * @see com.zjj.miniwechat.service.AddressService#addAddress(com.zjj.miniwechat.entity.Address)
	 */
	@Override
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		addressDao.addAddress(address);
	}

}
