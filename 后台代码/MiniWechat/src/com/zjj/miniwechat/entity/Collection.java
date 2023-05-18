package com.zjj.miniwechat.entity;

/**
 * @author 张建军
 *
 * 2019年5月6日下午8:55:23
 */
public class Collection {
	private Integer cid;
	private Integer gid;
	private Integer uid;
	private Integer isselect;
	public Integer getIsselect() {
		return isselect;
	}
	public void setIsselect(Integer isselect) {
		this.isselect = isselect;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
}
