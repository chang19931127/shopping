package com.czd.shopping.pojo;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *	×´Ì¬-ÉÌÆ·
 */
public class Status implements Serializable {

	private static final long serialVersionUID = -3217410637749525485L;
	
	private Integer sid;
	private String status;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
