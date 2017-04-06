package com.czd.shopping.pojo;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *	用户实体类
 */
public class Users implements Serializable{

	private static final long serialVersionUID = 3371560737961506763L;
	
	private Integer uid;
	private String  ulogin;
	private String uname;
	private String upass;
	private String usex;
	private String uphone;
	private String upost;
	private String uemail;
	private String uaddress;
	
	public Users() {
		super();
	}

	public Users(String ulogin, String uname, String upass, String usex,
			String uphone, String upost, String uemail, String uaddress) {
		super();
		this.ulogin = ulogin;
		this.uname = uname;
		this.upass = upass;
		this.usex = usex;
		this.uphone = uphone;
		this.upost = upost;
		this.uemail = uemail;
		this.uaddress = uaddress;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUlogin() {
		return ulogin;
	}

	public void setUlogin(String ulogin) {
		this.ulogin = ulogin;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUpost() {
		return upost;
	}

	public void setUpost(String upost) {
		this.upost = upost;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	
	
	
}
