package com.czd.shopping.action;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.czd.shopping.pojo.Forder;
import com.czd.shopping.pojo.SendData;
import com.czd.shopping.pojo.Users;
import com.czd.shopping.util.DigestUtil;

/**
 * 支付Action
 * 
 * @author Administrator
 *
 */
public class PayAction extends BaseAction<SendData> {

	private static final long serialVersionUID = -2696723288328909246L;

	private final String keyValue = "w0P75wMZ203fr46r5i70V556WHFa94j14yW5J6vuh4yo3nRl5jsqF3c41677";

	String formatString(String text) {
		if (text == null) {
			return "";
		}
		return text;
	}

	public String submit() {
		// 1,获取所有的数据
		// 2,对数据进行追加并加密
		String paramJoin = onlinePayService.joinOnlinePayParam(model);
		String hmac = DigestUtil.hmacSign(paramJoin, keyValue);
		// 3,存储到request对象，跳转
		// 明文和密文存储到request.setAttribute中
		request.put("sendData", model);
		request.put("hmac", hmac);
		return "reqpay";
	}

	public String success() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		String p1_MerId = "10000940764";
		String r0_Cmd = formatString(req.getParameter("r0_Cmd"));
		String r1_Code = formatString(req.getParameter("r1_Code"));
		String r2_TrxId = formatString(req.getParameter("r2_TrxId"));
		String r3_Amt = formatString(req.getParameter("r3_Amt"));
		String r4_Cur = formatString(req.getParameter("r4_Cur"));
		String r5_Pid = new String(
				formatString(req.getParameter("r5_Pid")).getBytes("iso-8859-1"),
				"UTF-8");
		String r6_Order = formatString(req.getParameter("r6_Order"));
		String r7_Uid = formatString(req.getParameter("r7_Uid"));
		String r8_MP = new String(
				formatString(req.getParameter("r8_MP")).getBytes("iso-8859-1"),
				"UTF-8");
		String r9_BType = formatString(req.getParameter("r9_BType"));
		String hmac = formatString(req.getParameter("hmac"));

		StringBuffer infoBuffer = new StringBuffer();
		infoBuffer.append(p1_MerId);
		infoBuffer.append(r0_Cmd);
		infoBuffer.append(r1_Code);
		infoBuffer.append(r2_TrxId);
		infoBuffer.append(r3_Amt);
		infoBuffer.append(r4_Cur);
		infoBuffer.append(r5_Pid);
		infoBuffer.append(r6_Order);
		infoBuffer.append(r7_Uid);
		infoBuffer.append(r8_MP);
		infoBuffer.append(r9_BType);
		String md5 = DigestUtil.hmacSign(infoBuffer.toString(), keyValue);
		boolean isOk = md5.equals(hmac);
		System.out.println("--->" + isOk);
		System.out.println("--->" + r1_Code);
		if (isOk && r1_Code.equals("1")) {
			// 支付成功，发送邮件
			Forder forder = (Forder) session.get("forder");
			Users users = (Users) session.get("users");
			shopEmailUtil.sendMessage(forder, users);
			req.setAttribute("info", "订单" + forder.getFid() + "支付成功");
		} else {
			// 支付失败
			req.setAttribute("info", "订单失败！");
		}
		return "payResult";
	}
}
