package com.czd.shopping.pojo;

import java.sql.Timestamp;

/**
 * 
 * @author Administrator
 *	商品bean，
 */
public class Goods {
	
	private Integer gid;		//id
	private String gname;		//商品名称
	private Double gprice;		//商品价格
	private String gpic;		//商品图面
	private String gremark;		//商品简单介绍
	private String gxremark;	//商品详细介绍
	private Timestamp gdate;	//商品生产日期
	private Boolean gcommend;	//是否推荐商品
	private Boolean gopen;		//是否有效商品
	private Category category;	//商品类别， 数据库中可以通过外键，我们java代码中可以通过关系
	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Double getGprice() {
		return gprice;
	}
	public void setGprice(Double gprice) {
		this.gprice = gprice;
	}
	public String getGpic() {
		return gpic;
	}
	public void setGpic(String gpic) {
		this.gpic = gpic;
	}
	public String getGremark() {
		return gremark;
	}
	public void setGremark(String gremark) {
		this.gremark = gremark;
	}
	public String getGxremark() {
		return gxremark;
	}
	public void setGxremark(String gxremark) {
		this.gxremark = gxremark;
	}
	public Timestamp getGdate() {
		return gdate;
	}
	public void setGdate(Timestamp gdate) {
		this.gdate = gdate;
	}
	public Boolean getGcommend() {
		return gcommend;
	}
	public void setGcommend(Boolean gcommend) {
		this.gcommend = gcommend;
	}
	public Boolean getGopen() {
		return gopen;
	}
	public void setGopen(Boolean gopen) {
		this.gopen = gopen;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
