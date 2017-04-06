package com.czd.shopping.service.impl;

import com.czd.shopping.pojo.Forder;
import com.czd.shopping.pojo.Sorder;
import com.czd.shopping.service.ForderService;

public class ForderServiceImpl extends BaseServiceImpl<Forder>
		implements
			ForderService {

	@Override
	public double cluFtotal(Forder forder) {
		double ftotal = 0.0;
		for (Sorder temp : forder.getSorders()) {
			ftotal += temp.getSnumber() * temp.getSprice();
		}
		return ftotal;
	}

}
