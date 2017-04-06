package com.czd.shopping.service;

import java.util.List;

import com.czd.shopping.pojo.Goods;

public interface GoodsService extends BaseService<Goods> {

	//根据热点类别ID，查询推荐商品
	List<Goods> queryGoodsByCid(int cid);
	//根据商品名称，查询商品
	List<Goods> queryGoodsByGname(String gname);
}
