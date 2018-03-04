package com.yc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Car;
import com.yc.bean.Driver;
import com.yc.bean.Goods;
import com.yc.bean.Handover;
import com.yc.bean.JsonModel;
import com.yc.bean.Order1;
import com.yc.bean.Orderinfo;
import com.yc.bean.Route;
import com.yc.bean.Shippoint;
import com.yc.bean.Users;
import com.yc.biz.GoodsBiz;
import com.yc.biz.HandoverBiz;
import com.yc.biz.Order1Biz;
import com.yc.biz.OrderInfoBiz;
import com.yc.biz.RouteBiz;

@Controller
@Scope(value="prototype")
public class Order1Controller {

	@Resource(name="order1BizImpl")
	private Order1Biz order1Biz;
	@Resource(name="orderInfoBizImpl")
	private OrderInfoBiz orderInfoBiz;
	@Resource(name="routeBizImpl")
	private RouteBiz routeBiz;
	@Resource(name="handoverBizImpl")
	private HandoverBiz handoverBiz;
	@Resource(name="goodsBizImpl")
	private GoodsBiz goodsBiz;
	private JsonModel jsonModel=new JsonModel();

	@RequestMapping(value="addOrder.action")
	public @ResponseBody JsonModel addOrder(Order1 order1,@RequestParam Integer spid) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		order1.setOstarttime(sdf.parse(order1.getOstarttimeString()));
		order1.setOendtime(sdf.parse(order1.getOendtimeString()));
		order1.setOtime(new Date());
		try {
			Shippoint shipPoint=new Shippoint();
			Users user=new Users();
			user.setUsid(15);
			order1.setUsers(user);
			shipPoint.setSpid(spid);
			order1.setShipPoint(shipPoint);
			order1Biz.addOrder1(order1);
			Integer osid=order1.getOsid();
			jsonModel.setCode(1);
			jsonModel.setObj(order1);
			Order1 o=new Order1();
			o.setOsid(osid);
			Order1 or=new Order1();
			or=  order1Biz.findRid(o);
			Integer rid=Integer.parseInt(or.getRemark1());
			Route r=new Route();
			r.setRid(rid);
			Route route=new Route();
			route=routeBiz.findRvia(r);
			String rvia=route.getRvia();
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

	@RequestMapping("findOrderPages.action")
	public @ResponseBody JsonModel findAllToPage(Order1 order1,@RequestParam(name="pages") Integer pages,@RequestParam(name="pageSize") Integer pageSize){
		Order1 orderCopy=order1;
		orderCopy.setPageNo(null);
		orderCopy.setPageSize(null);
		//算出数据的总数量
		jsonModel.setTotal(order1Biz.findAllOrderToPage(orderCopy).size());
		jsonModel.setPages(pages);
		jsonModel.setPageSize(pageSize);
		order1.setPageNo((pages-1)*pageSize);	
		order1.setPageSize(pageSize);
		List<Order1> orderObj=new ArrayList<Order1>();
		try {
			List<Order1> listOrder=order1Biz.findAllOrderToPage(order1);
			//需要把每个订单的订单商品拼接在一起   暂时用remark4存储
			for(Order1 order:listOrder){
				String goodsName="";
				String goodsCount="";
				for(Orderinfo orderinfo:order.getOrderinfoList()){
					goodsName+=orderinfo.getGname()+",";
					goodsCount+=orderinfo.getGcount()+",";
					order.setRemark4(goodsName.substring(0, goodsName.length()-1));
					order.setRemark3(goodsCount.substring(0,goodsCount.length()-1));
				}
				orderObj.add(order);
			}
			jsonModel.setObj(orderObj);
			jsonModel.setCode(1);
		} catch (Exception e) {
			jsonModel.setCode(0);
			e.printStackTrace();
		}
		return jsonModel;
	}
	

	@RequestMapping("delOrder.action")
	@ResponseBody
	public JsonModel delOrder(@RequestParam(name="stringOsid") String stringOsid){
		try {
			String[] shuzuOsid=stringOsid.split("-");
			List<Integer> listOrder=new ArrayList<Integer>();
			List<Integer> listRid=new ArrayList<Integer>();
			for(String osid:shuzuOsid){
				Order1 o=new Order1();
				o.setOsid(Integer.parseInt(osid));
				Order1 or=new Order1();
				or=  order1Biz.findRid(o);
				Integer rid=Integer.parseInt(or.getRemark1());
				listOrder.add(Integer.parseInt(osid));
				listRid.add(rid);
			}
			order1Biz.delOrder(listOrder);
			orderInfoBiz.delOrderInfo(listOrder);
			routeBiz.deleteRoute(listRid);
			jsonModel.setCode(1);
		} catch (NumberFormatException e) {
			jsonModel.setCode(0);
			e.printStackTrace();
		}
		return jsonModel;
	}
	
	@RequestMapping("findOrderByOsid.action")
	@ResponseBody
	public JsonModel findOrderByOsid(Order1 order1){
		List<Order1> orderObj=new ArrayList<Order1>();
		try {
			List<Order1> listOrder=order1Biz.findAllOrderToPage(order1);
			//需要把每个订单的订单商品拼接在一起   暂时用remark4存储
			for(Order1 order:listOrder){
				String goodsName="";
				String goodsCount="";
				int orderinfoIndex=0;
				for(Orderinfo orderinfo:order.getOrderinfoList()){
					goodsName+=orderinfo.getGname()+",";
					goodsCount+=orderinfo.getGcount()+",";
					order.setRemark4(goodsName.substring(0, goodsName.length()-1));
					order.setRemark3(goodsCount.substring(0,goodsCount.length()-1));
					Goods goods=new Goods();
					goods.setGname(orderinfo.getGname());
					List<Goods> listGoods=goodsBiz.selectAllGoods(goods);
					order.getOrderinfoList().get(orderinfoIndex).setRemark4(String.valueOf(listGoods.get(0).getGid()));
					order.getOrderinfoList().get(orderinfoIndex++).setRemark5(String.valueOf(listGoods.get(0).getGtype()));
				}
				orderObj.add(order);
			}
			jsonModel.setObj(orderObj);
			jsonModel.setCode(1);
		}catch (Exception e) {
			jsonModel.setCode(0);
			e.printStackTrace();
		}
		return jsonModel;
	}
	
	@RequestMapping(value="updateOrder.action")
	public @ResponseBody JsonModel updateOrder(Order1 order1,@RequestParam Integer spid) throws Exception{
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
			order1Biz.updateOrder1(order1);
			//Integer osid=order1.getOsid();
			jsonModel.setCode(1);
			jsonModel.setObj(order1);
			/*Order1 o=new Order1();
			o.setOsid(osid);
			Order1 or=new Order1();
			or=  order1Biz.findRid(o);
			Integer rid=Integer.parseInt(or.getRemark1());
			Route r=new Route();
			r.setRid(rid);
			Route route=new Route();
			route=routeBiz.findRvia(r);
			String rvia=route.getRvia();
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
			}*/
		} catch (Exception e) {
			jsonModel.setCode(0);
			e.printStackTrace();
		}
		return jsonModel;
	}
	
	
}
