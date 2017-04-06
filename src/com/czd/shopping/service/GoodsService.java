package com.czd.shopping.service;

import java.util.List;

import com.czd.shopping.pojo.Goods;

public interface GoodsService extends BaseService<Goods> {

	//�����ȵ����ID����ѯ�Ƽ���Ʒ
	List<Goods> queryGoodsByCid(int cid);
	//������Ʒ���ƣ���ѯ��Ʒ
	List<Goods> queryGoodsByGname(String gname);
}
