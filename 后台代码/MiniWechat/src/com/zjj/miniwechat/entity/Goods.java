package com.zjj.miniwechat.entity;

/**
 * @author 张建军
 *
 * 2019年5月5日下午7:34:50
 */
public class Goods {
	private int gid;
	private String gname;
	private String gimage;
	private String gdesc;
	private int gnum;
	private int gprice;
	private int uid;
	private int gstate;
	
	public int getGstate() {
		return gstate;
	}
	public void setGstate(int gstate) {
		this.gstate = gstate;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGimage() {
		return gimage;
	}
	public void setGimage(String gimage) {
		this.gimage = gimage;
	}
	public String getGdesc() {
		return gdesc;
	}
	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}
	
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
