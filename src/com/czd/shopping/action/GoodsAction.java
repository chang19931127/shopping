package com.czd.shopping.action;

import com.czd.shopping.pojo.Goods;
import com.czd.shopping.pojo.GoodsFile;

/**
 * 
 * @author Administrator
 *	商品的 控制层，
 *	这里需要一个文件上传功能，封装一个模块，调用即可(单例)
 */
public class GoodsAction extends BaseAction<Goods> {
	
	private static final long serialVersionUID = 910369652551535565L;

	private GoodsFile goodsFile;
	
	
	public GoodsFile getGoodsFile() {
		return goodsFile;
	}


	public void setGoodsFile(GoodsFile goodsFile) {
		this.goodsFile = goodsFile;
	}

	
	public String save(){
		//其实我们实际中不会使用这样的    方式，因为这样的方式没有办法在客户端记性文件的校验，这样子不太好
		String newName = fileUploadUtil.uploadFile(goodsFile.getImage(), goodsFile.getImageFileName(),"D:/0105");
		System.out.println("file location is =" + goodsFile.getImageFileName());
		model.setGpic(newName);
		System.out.println(model.getGpic());
		goodsService.save(model);
		return "main";
	}
	
	public String query(){
		System.out.println(model.getGname());
		session.put("gname", model.getGname());
		request.put("goodsList", goodsService.queryGoodsByGname(model.getGname()));
		return "query";
	}
	
	public String update(){
		if(goodsFile == null){
			goodsService.update(model);
		}else{
			//删除原来的
			fileUploadUtil.delete(model.getGpic());
			//上传新的
			String newName = fileUploadUtil.uploadFile(goodsFile.getImage(), goodsFile.getImageFileName());
			model.setGpic(newName);
			goodsService.update(model);
		}
		return "query";
	}
	
	public String detail(){
		request.put("goods", goodsService.get(model.getGid()));
		return "detail";
	}
	
	public String get(){
		request.put("goods", goodsService.get(model.getGid()));
		return "update";
	}
	
	public String delete(){
		goodsService.delete(model.getGid());
		request.put("goodsList", goodsService.queryGoodsByGname((String)session.get("gname")));
		return "query";
	}
}
