package com.zjj.miniwechat.dao;

import java.util.List;

import com.zjj.miniwechat.entity.Address;

/**
 * @author 张建军
 *
 * 2019年5月7日下午7:24:22
 */
public interface AddressDao {
	/**
	 * @param uid
	 * @return
	 */
	public List<Address> findAddressById(int uid);
	
	/**
	 * @param aid
	 */
	public void deleteAddress(int aid);
	
	/**
	 * @param aid
	 * @return
	 */
	public Address findOneAddress(int aid);
	
	/**
	 * @param address
	 */
	public void addAddress(Address address);
	
//	/**更新某个地址为默认的地址
//	 * @param aid
//	 */
//	public void updateDefaultAddress(int aid);
}
