package com.zjj.miniwechat.service;

import java.util.List;

import com.zjj.miniwechat.entity.Address;

/**
 * @author 张建军
 *
 * 2019年5月7日下午7:29:08
 */
public interface AddressService {
	/**
	 * @param uid
	 * @return
	 */
	public List<Address> findAddressById(int uid);
	
	/**
	 * @param aid
	 */
	public void deleteAddress(int aid);
	
	public Address findOneAddress(int aid);
	
	/**
	 * @param address
	 */
	public void addAddress(Address address);
}
