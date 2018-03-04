package com.yc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.JsonModel;
import com.yc.bean.Order1;
import com.yc.bean.Orderinfo;
import com.yc.biz.OrderInfoBiz;

@Controller
@Scope(value="prototype")
public class OrderInfoController {
	
	@Resource(name="orderInfoBizImpl")
	private OrderInfoBiz orderInfoBizImpl;
	
	private JsonModel jsonModel=new JsonModel();
	
	@RequestMapping("addOrderInfo.action")
	public @ResponseBody JsonModel addOrderInfo(@RequestParam Integer osid,@RequestParam String goodsNames,@RequestParam String goodsCounts,
			@RequestParam String goodsPrices,@RequestParam String goodsGweights,@RequestParam String goodsGvolumes,@RequestParam String goodsGremarks){
		try {
			Orderinfo orderinfo1=new Orderinfo();
			orderinfo1.setOiid(osid);
			orderInfoBizImpl.delOrderInfoByOsid(orderinfo1);
			//将osid这个id赋给order1这个对象
			Order1 order=new Order1();
			order.setOsid(osid);
			
			//将拼接起来的字符串截取
			String[] goodsName=goodsNames.split("-");
			String[] goodsCount=goodsCounts.split("-");
			String[] goodsPrice=goodsPrices.split("-");
			String[] goodsGweight=goodsGweights.split("-");
			String[] goodsGvolume=goodsGvolumes.split("-");
			String[] goodsGremark=goodsGremarks.split("-");
			for(int i=0;i<goodsName.length;i++){
				Orderinfo orderinfo=new Orderinfo();
				orderinfo.setOrder1(order);
				orderinfo.setGname(goodsName[i]);
				orderinfo.setGcount(Integer.parseInt(goodsCount[i]));
				orderinfo.setGprice(Double.parseDouble(goodsPrice[i]));
				//备注
				if(goodsGremark.length>i){
					orderinfo.setRemark1(goodsGremark[i]);
				}
				orderinfo.setRemark2(goodsGweight[i]);
				orderinfo.setRemark3(goodsGvolume[i]);
				orderInfoBizImpl.addOrderInfoDao(orderinfo);
			}
			jsonModel.setCode(1);
		} catch (NumberFormatException e) {
			jsonModel.setCode(0);
			e.printStackTrace();
		}
		return jsonModel;
	}
}
