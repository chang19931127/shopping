package com.czd.shopping.pojo;

/**
 * @author MyEclipse Persistence Tools
 * 类似于这种pojo我们后期可以使用逆向代码生成工具来进行生成
 * 逆向代码生成工具
 */
public class Category {
	private Integer cid;
	private String ctype;
	private Boolean chot;
	private Integer aid;

	public Category() {
		super();
	}

	public Category(String ctype, Boolean chot, Integer aid) {
		super();
		this.ctype = ctype;
		this.chot = chot;
		this.aid = aid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public Boolean getChot() {
		return chot;
	}

	public void setChot(Boolean chot) {
		this.chot = chot;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	
}
