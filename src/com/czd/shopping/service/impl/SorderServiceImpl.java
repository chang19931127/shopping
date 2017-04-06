package com.czd.shopping.service.impl;

import java.util.Set;

import com.czd.shopping.pojo.Forder;
import com.czd.shopping.pojo.Sorder;
import com.czd.shopping.service.SorderService;

public class SorderServiceImpl extends BaseServiceImpl<Sorder>
		implements
			SorderService {

	@Override
	public Forder addSorder(Forder forder, Sorder sorder) {
		boolean isHave = false;
		Set<Sorder> sorders = forder.getSorders();
		for (Sorder temp : sorders) {
			if (temp.getGoods().getGid().equals(sorder.getGoods().getGid())) {
				temp.setSnumber(temp.getSnumber() + 1);
				isHave = true;
				break;
			}
		}
		//如果没有，就新填到结合中
		if(!isHave){
			sorders.add(sorder);
		}
		return forder;
	}

	@Override
	public Forder removeSorder(Forder forder, int gid) {
		Set<Sorder> sorders = forder.getSorders();
		for (Sorder temp : sorders) {
			if(temp.getGoods().getGpic().equals(gid)){
				sorders.remove(temp);
				break;
			}
		}
		return forder;
	}

}
