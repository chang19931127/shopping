package com.czd.shopping.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Administrator
 *	订单实体类，也就是购物车
 */
public class Forder implements Serializable {

	private static final long serialVersionUID = -1517385401506796465L;
	
	private Integer fid;
	private String fname;
	private String fphone;
	private String fremark;
	private String femail;
	private Timestamp fdate;
	private Double ftotal;
	private String fpost;
	private Users users;
	private Status status;
	
	//购物车中要存储商品，也就是购物项
	private Set<Sorder> sorders = new HashSet<>();

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFphone() {
		return fphone;
	}

	public void setFphone(String fphone) {
		this.fphone = fphone;
	}

	public String getFremark() {
		return fremark;
	}

	public void setFremark(String fremark) {
		this.fremark = fremark;
	}

	public String getFemail() {
		return femail;
	}

	public void setFemail(String femail) {
		this.femail = femail;
	}

	public Timestamp getFdate() {
		return fdate;
	}

	public void setFdate(Timestamp fdate) {
		this.fdate = fdate;
	}

	public Double getFtotal() {
		return ftotal;
	}

	public void setFtotal(Double ftotal) {
		this.ftotal = ftotal;
	}

	public String getFpost() {
		return fpost;
	}

	public void setFpost(String fpost) {
		this.fpost = fpost;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Sorder> getSorders() {
		return sorders;
	}

	public void setSorders(Set<Sorder> sorders) {
		this.sorders = sorders;
	}
	
	
	
}
