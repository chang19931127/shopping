package com.czd.shopping.pojo;

import java.io.Serializable;

//Account     �û�bean
//һ���ܼ򵥵�bean
public class Account implements Serializable {
	private static final long serialVersionUID = 7207703117487703483L;
	private Integer aid; // id
	private String alogin; // ��¼
	private String aname; // ����
	private String apass; // ����
	public Account() {
		super();
	}
	public Account(String alogin, String aname, String apass) {
		super();
		this.alogin = alogin;
		this.aname = aname;
		this.apass = apass;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAlogin() {
		return alogin;
	}
	public void setAlogin(String alogin) {
		this.alogin = alogin;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApass() {
		return apass;
	}
	public void setApass(String apass) {
		this.apass = apass;
	}

	public String toString() {
		return "[" + alogin + "," + aname + "," + apass + "]";
	}

}
