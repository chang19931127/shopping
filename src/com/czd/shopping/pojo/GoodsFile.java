package com.czd.shopping.pojo;

import java.io.File;

/**
 * 
 * @author Administrator
 *	商品文件
 */
public class GoodsFile {
	private File image;
	private String imageFileName;
	private String imageContentType;
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	
}
