package com.czd.shopping.pojo;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *	订单中的 购物项，也就是 购物车中的 一个商品
 */
public class Sorder implements Serializable {

	private static final long serialVersionUID = -2114837719216310184L;
	
	private Integer sid;
	private String sname;
	private Double sprice;
	private Integer snumber;
	private Goods goods;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Double getSprice() {
		return sprice;
	}
	public void setSprice(Double sprice) {
		this.sprice = sprice;
	}
	public Integer getSnumber() {
		return snumber;
	}
	public void setSnumber(Integer snumber) {
		this.snumber = snumber;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	

}
