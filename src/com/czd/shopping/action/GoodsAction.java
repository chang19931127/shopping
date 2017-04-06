package com.czd.shopping.action;

import com.czd.shopping.pojo.Goods;
import com.czd.shopping.pojo.GoodsFile;

/**
 * 
 * @author Administrator
 *	��Ʒ�� ���Ʋ㣬
 *	������Ҫһ���ļ��ϴ����ܣ���װһ��ģ�飬���ü���(����)
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
		//��ʵ����ʵ���в���ʹ��������    ��ʽ����Ϊ�����ķ�ʽû�а취�ڿͻ��˼����ļ���У�飬�����Ӳ�̫��
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
			//ɾ��ԭ����
			fileUploadUtil.delete(model.getGpic());
			//�ϴ��µ�
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
