package com.czd.shopping.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.czd.shopping.pojo.Goods;
import com.czd.shopping.service.GoodsService;

/**
 * 
 * @author Administrator
 *	商品的业务实现类
 */
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {
	
	/*
	 * 这里 spring只负责事物，不负责hibernate的持久化，因此我们这里需要进行回调
	 * 什么是回调，就是通过某些开关，来控制一些方法的执行
	 * 这里我们的hibernateTemplate没有提供分页，则可以通过回调技术(session)来解决
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> queryGoodsByCid(final int cid) {
		//一般返回
//		return hibernateTemplate
//				.findByNamedParam(
//						"FROM Goods g WHERE g.gcommend=true AND g.gopen=true AND g.category.cid=:cid ORDER BY g.gdate DESC",
//						"cid", cid);
		// 每个类别查询3个商品
		//利用回调
		return (List<Goods>) hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery("FROM Goods g WHERE g.gcommend=true AND g.gopen=true " +
						"AND g.category.cid=:cid ORDER BY g.gdate DESC")
						.setInteger("cid", cid)
						.setFirstResult(0)
						.setMaxResults(3)
						.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> queryGoodsByGname(String gname) {
		return hibernateTemplate.findByNamedParam("FROM Goods g WHERE g.gname LIKE :gname", "gname", "%"+gname+"%");
	}
	
}
