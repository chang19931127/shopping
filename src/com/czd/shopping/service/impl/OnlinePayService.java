package com.czd.shopping.service.impl;

import java.util.Map;

import com.czd.shopping.pojo.BackData;
import com.czd.shopping.pojo.SendData;

/**
 * 网上支付Service
 * 
 * @author Administrator
 *
 */
public class OnlinePayService {
	//追加要输出的数据，未加密做准备
	public String joinOnlinePayParam(SendData sendData) {
		StringBuffer infoBuffer = new StringBuffer();
		infoBuffer.append(sendData.getP0_Cmd());
		infoBuffer.append(sendData.getP1_MerId());
		infoBuffer.append(sendData.getP2_Order());
		infoBuffer.append(sendData.getP3_Amt());
		infoBuffer.append(sendData.getP4_Cur());
		infoBuffer.append(sendData.getP5_Pid());
		infoBuffer.append(sendData.getP6_Pcat());
		infoBuffer.append(sendData.getP7_Pdesc());
		infoBuffer.append(sendData.getP8_Url());
		infoBuffer.append(sendData.getP9_SAF());
		infoBuffer.append(sendData.getPa_MP());
		infoBuffer.append(sendData.getPd_FrpId());
		infoBuffer.append(sendData.getPr_NeedResponse());
		return infoBuffer.toString();
	}

	//从支付结果返回的数据，为加密做准备
	public String joinOnlinePayParam(BackData backData) {
		StringBuffer infoBuffer = new StringBuffer();
		infoBuffer.append(backData.getP1_MerId());
		infoBuffer.append(backData.getR0_Cmd());
		infoBuffer.append(backData.getR1_Code());
		infoBuffer.append(backData.getR2_TrxId());
		infoBuffer.append(backData.getR3_Amt());
		infoBuffer.append(backData.getR4_Cur());
		infoBuffer.append(backData.getR5_Pid());
		infoBuffer.append(backData.getR6_Order());
		infoBuffer.append(backData.getR7_Uid());
		infoBuffer.append(backData.getR8_MP());
		infoBuffer.append(backData.getR9_BType());
		return infoBuffer.toString();
	}
	
	// 获取传输过来的数据
	public BackData valueToBackData(Map<String, String[]> paramters) {
		BackData backData = new BackData();
		backData.setP1_MerId(formatString(paramters.get("p1_MerId")[0]));
		backData.setR0_Cmd(formatString(paramters.get("r0_Cmd")[0]));
		backData.setR1_Code(formatString(paramters.get("r1_Code")[0]));
		backData.setR2_TrxId(formatString(paramters.get("r2_TrxId")[0]));
		backData.setR3_Amt(formatString(paramters.get("r3_Amt")[0]));
		backData.setR4_Cur(formatString(paramters.get("r4_Cur")[0]));
		backData.setR5_Pid(formatString(paramters.get("r5_Pid")[0]));
		backData.setR6_Order(formatString(paramters.get("r6_Order")[0]));
		backData.setR7_Uid(formatString(paramters.get("r7_Uid")[0]));
		backData.setR8_MP(formatString(paramters.get("r8_MP")[0]));
		backData.setR9_BType(formatString(paramters.get("r9_BType")[0]));
		return backData;
	}
	
	private String formatString(String text) {
		if (text == null) {
			return "";
		}
		return text;
	}
	
	
}
