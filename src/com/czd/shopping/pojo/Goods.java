package com.czd.shopping.pojo;

import java.sql.Timestamp;

/**
 * 
 * @author Administrator
 *	��Ʒbean��
 */
public class Goods {
	
	private Integer gid;		//id
	private String gname;		//��Ʒ����
	private Double gprice;		//��Ʒ�۸�
	private String gpic;		//��Ʒͼ��
	private String gremark;		//��Ʒ�򵥽���
	private String gxremark;	//��Ʒ��ϸ����
	private Timestamp gdate;	//��Ʒ��������
	private Boolean gcommend;	//�Ƿ��Ƽ���Ʒ
	private Boolean gopen;		//�Ƿ���Ч��Ʒ
	private Category category;	//��Ʒ��� ���ݿ��п���ͨ�����������java�����п���ͨ����ϵ
	
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
