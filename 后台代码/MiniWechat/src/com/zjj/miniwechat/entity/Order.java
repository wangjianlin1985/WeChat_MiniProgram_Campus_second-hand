package com.zjj.miniwechat.entity;

import java.util.Date;

/**
 * @author 张建军
 *
 * 2019年5月10日下午7:28:53
 */
public class Order {
	private int oid ;
	private Double price;
	private Date createtime;
	private int uid;
	private int aid;
	private int gid;
	private int gstatus;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getGstatus() {
		return gstatus;
	}
	public void setGstatus(int gstatus) {
		this.gstatus = gstatus;
	}
	
}
