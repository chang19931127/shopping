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
 *	��Ʒ��ҵ��ʵ����
 */
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {
	
	/*
	 * ���� springֻ�������������hibernate�ĳ־û����������������Ҫ���лص�
	 * ʲô�ǻص�������ͨ��ĳЩ���أ�������һЩ������ִ��
	 * �������ǵ�hibernateTemplateû���ṩ��ҳ�������ͨ���ص�����(session)�����
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> queryGoodsByCid(final int cid) {
		//һ�㷵��
//		return hibernateTemplate
//				.findByNamedParam(
//						"FROM Goods g WHERE g.gcommend=true AND g.gopen=true AND g.category.cid=:cid ORDER BY g.gdate DESC",
//						"cid", cid);
		// ÿ������ѯ3����Ʒ
		//���ûص�
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
