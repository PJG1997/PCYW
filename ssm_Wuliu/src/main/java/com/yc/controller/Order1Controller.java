package com.yc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Car;
import com.yc.bean.Driver;
import com.yc.bean.Handover;
import com.yc.bean.JsonModel;
import com.yc.bean.Order1;
import com.yc.bean.Route;
import com.yc.bean.Shippoint;
import com.yc.bean.Users;
import com.yc.biz.HandoverBiz;
import com.yc.biz.Order1Biz;
import com.yc.biz.RouteBiz;

@Controller
@Scope(value="prototype")
public class Order1Controller {

	@Resource(name="order1BizImpl")
	private Order1Biz order1Biz;
	@Resource(name="routeBizImpl")
	private RouteBiz routeBiz;
	@Resource(name="handoverBizImpl")
	private HandoverBiz handoverBiz;
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
			Integer osid=order1Biz.addOrder1(order1);
			jsonModel.setCode(1);
			jsonModel.setObj(order1);
			Order1 o=new Order1();
			o.setOsid(osid);
			Order1 or=new Order1();
			or=  order1Biz.findRid(o);
			Integer rid=Integer.parseInt(or.getRemark1());
			Route r=new Route();
			r.setRid(rid);
			String rvia=routeBiz.findRvia(r).getRvia();
			String rivaname[]=rvia.split("-");
			for(int i=0;i<rivaname.length-1;i++){
				Handover h=new Handover();
				h.setHfromspname(rivaname[i]);
				h.setHtospname(rivaname[i+1]);
				h.setOrder1(o);
				h.setRoute(r);
				Car c=new Car();
				Driver d=new Driver();
				h.setCar(c);
				h.setDriver(d);
				h.setHstatus(0);
				h.setRemark5("1");
				handoverBiz.addHandover(h);
			}
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
