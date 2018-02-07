package com.yc.controller;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.JsonModel;
import com.yc.bean.Order1;
import com.yc.bean.Shippoint;
import com.yc.bean.Users;
import com.yc.biz.Order1Biz;

@Controller
@Scope(value="prototype")
public class Order1Controller {

	@Resource(name="order1BizImpl")
	private Order1Biz order1Biz;
	private JsonModel jsonModel=new JsonModel();
	
	@RequestMapping(value="addOrder.action")
	public @ResponseBody JsonModel addOrder(Order1 order1,@RequestParam Integer spid) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		order1.setOstarttime(sdf.parse(order1.getOstarttimeString()));
		order1.setOendtime(sdf.parse(order1.getOendtimeString()));
		try {
			Shippoint shipPoint=new Shippoint();
			Users user=new Users();
			user.setUsid(15);
			order1.setUsers(user);
			shipPoint.setSpid(spid);
			order1.setShipPoint(shipPoint);
			order1Biz.addOrder1(order1);
			jsonModel.setCode(1);
			jsonModel.setObj(order1);
		} catch (Exception e) {
			jsonModel.setCode(0);
			e.printStackTrace();
		}
		return jsonModel;
	}
	
	@RequestMapping("findAllo.action")
	@ResponseBody
	public JsonModel findAll(){
		jsonModel.setObj(order1Biz.findAll());
		return jsonModel;
	}
}
