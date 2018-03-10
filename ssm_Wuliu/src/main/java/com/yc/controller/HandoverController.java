package com.yc.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.yc.bean.Handover;
import com.yc.bean.JsonModel;
import com.yc.bean.Order1;
import com.yc.bean.Route;
import com.yc.biz.HandoverBiz;
import com.yc.biz.Order1Biz;

@Controller
@Scope(value="prototype")
public class HandoverController {
	@Resource(name="handoverBizImpl")
	private HandoverBiz handoverBiz;
	@Resource(name="order1BizImpl")
	private Order1Biz order1Biz;
	private JsonModel jsonModel=new JsonModel();
	private Car c=new Car();
	private Driver d=new Driver(); 
	private Order1 o=new Order1();
	private Route r=new Route();
	//后台查询:分步式查询，一步一步来完善信息达到查询所有交接单的目的
	@RequestMapping("findAllhandover.action")
	@ResponseBody
	public Map<String,Object> findAllhandover(Handover h,HttpServletRequest request){
		Map<String,Object> map=new HashMap<String, Object>();
		h.setCar(c);
		h.setDriver(d);
		h.setOrder1(o);
		h.setRoute(r);
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		h.setPageNo((pageNo-1)*pageSize);
		h.setPageSize(pageSize);
		int total = handoverBiz.getFirstHandoverInfo(h).size();
		map.put("total", total);
		List<Handover> list=new ArrayList<Handover>();
		for(Handover hand:handoverBiz.getFirstHandoverInfo(h))//getFirstHandoverInfo:查询初步需要的交接单信息里面只含有cid,did等列
		{	
			
			if(hand.getHstatus()==0){
				hand.setStatus("未发车");
			}else if(hand.getHstatus()==1){
				hand.setStatus("已发车");
			}else{
				hand.setStatus("以完成");
			}
			if(hand.getCar()!=null){//判断该交接单有无车辆属性
				if(hand.getCar().getCid()!=null){//如果该交接单已经分配了车辆
					Handover h2 = handoverBiz.getCnumberByHandover(hand);//则通过交接单的cid来查询车辆车牌号
					hand.setCnumber(h2.getCar().getCnumber());//完善交接单车辆车牌号信息
				}else{
					hand.setCnumber(null);
				}
			}else{
				hand.setCar(c);//没有车辆属性就赋予它一个null的车辆属性
			}
			
			if(hand.getDriver()!=null){//判断是否分配了司机
				if(hand.getDriver().getDid()!=null){
					Handover h2 = handoverBiz.getDnameByHandover(hand);//如果有司机分配，则通过交接单的did来查询司机名称
					hand.setDname(h2.getDriver().getDname());//完善交接单司机信息
				}else{
					hand.setDname(null);
				}
			}else{
				hand.setDriver(d);//没有司机就给它一个空的司机
			}
			hand.setOsid(hand.getOrder1().getOsid());
			hand.setRname(hand.getRoute().getRname());
			hand.setRemark4(String.valueOf(hand.getHid()));
			list.add(hand);
		}
		map.put("rows", list);
		return map;
	}
	
	//后台查看交接单查询
	@RequestMapping("findhandoverInfo.action")
	@ResponseBody
	public JsonModel findhandoverInfo(Handover h){
		h.setCar(c);
		h.setDriver(d);
		h.setRoute(r);
		h.setOrder1(o);
		jsonModel.setObj(handoverBiz.getHandoverInfo(h));
		return jsonModel;
	}
	

	//查询交接单
	@RequestMapping("selectInfo.action")
	@ResponseBody
	public Map<String,Object> searchHandoverInfo(HttpServletRequest request) throws ParseException{
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		String hstatus = request.getParameter("hstatus");
		String hid=request.getParameter("hid");
		String hstarttime = request.getParameter("hstarttime");
		String hfromspname = request.getParameter("hfromspname");
		String htospname = request.getParameter("htospname");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Handover h=new Handover();
		h.setHstatus(Integer.parseInt(hstatus));
		System.out.println(hid);
		h.setHid(Integer.parseInt(hid));
		h.setHstarttimeString(hstarttime);
		h.setHfromspname(hfromspname);
		h.setHtospname(htospname);
		
		map.put("total",handoverBiz.getHandoverInfo(h).size());
		map.put("list", handoverBiz.getHandoverInfo(h));
		
		
		
		return map;
		
	}
	

	//后台修改交接单
	@RequestMapping("updatehandover.action")
	@ResponseBody
	public JsonModel updatehandover(@RequestParam(value="update_insert_hid") Integer hid,
			@RequestParam(value="update_insert_hfromspname") String hfromspname,@RequestParam(value="update_insert_cnumber") Integer cid,
			@RequestParam(value="update_insert_dname") Integer did,@RequestParam(value="update_insert_osid") Integer osid,
			@RequestParam(value="update_insert_rname") Integer rid,@RequestParam(value="update_insert_htospname") String htospname,
			@RequestParam(value="update_insert_hstarttime") String starttime,@RequestParam(value="update_insert_hendtime") String endtime,
			@RequestParam(value="update_insert_hstatus") Integer hstatus,@RequestParam(value="update_insert_hremark") String hremark) throws ParseException{
			Handover h=new Handover();
			c.setCid(cid);
			o.setOsid(osid);
			d.setDid(did);
			r.setRid(rid);
			h.setCar(c);
			h.setDriver(d);
			h.setOrder1(o);
			h.setRoute(r);
			h.setHfromspname(hfromspname);
			h.setHtospname(htospname);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			h.setHstarttime(sdf.parse(starttime));
			h.setHendtime(sdf.parse(endtime));
			h.setHstatus(hstatus);
			h.setHremark(hremark);
			try {
				handoverBiz.updateHandoverInfo(h);
			} catch (Exception e) {
				jsonModel.setCode(0);
				e.printStackTrace();
				return jsonModel;
			}
			jsonModel.setCode(1);
			return jsonModel;
	}
	//后台添加
	@RequestMapping("addhandover.action")
	@ResponseBody
	public JsonModel addHandover(@RequestParam(value="update_insert_hid") Integer hid,
			@RequestParam(value="update_insert_hfromspname") String hfromspname,@RequestParam(value="update_insert_cnumber") Integer cid,
			@RequestParam(value="update_insert_dname") Integer did,@RequestParam(value="update_insert_osid") Integer osid,
			@RequestParam(value="update_insert_rname") Integer rid,@RequestParam(value="update_insert_htospname") String htospname,
			@RequestParam(value="update_insert_hstarttime") Date hstarttime,@RequestParam(value="update_insert_hendtime") Date hendtime,
			@RequestParam(value="update_insert_hstatus") Integer hstatus,@RequestParam(value="update_insert_hremark") String hremark){
		Handover h=new Handover();
		c.setCid(cid);
		o.setOsid(osid);
		d.setDid(did);
		r.setRid(rid);
		h.setCar(c);
		h.setDriver(d);
		h.setOrder1(o);
		h.setRoute(r);
		h.setHfromspname(hfromspname);
		h.setHtospname(htospname);
		h.setHstarttime(hstarttime);
		h.setHendtime(hendtime);
		h.setHstatus(hstatus);
		h.setHremark(hremark);
		try {
			handoverBiz.addHandover(h);
		} catch (Exception e) {
			jsonModel.setObj(0);
			e.printStackTrace();
			return jsonModel;
		}
		jsonModel.setCode(1);
		return jsonModel;
	}
	//用户的添加  点击订单完成后实现该订单的所有交接单
	@RequestMapping("useraddhandover.action")
	@ResponseBody
	public JsonModel useraddhandover(@Param(value = "osid") Integer osid){
		Order1 o=new Order1();
		o.setOsid(osid);
		Order1 or=new Order1();
		or=(Order1) order1Biz.findRid(o);
		Integer rid=Integer.parseInt(or.getRemark1());

		return jsonModel;
	}
	//后台批量删除
	@RequestMapping("delhandover.action")
	@ResponseBody
	public int delHandover(@Param(value = "hid") String hid){
		String hids[]=hid.split(",");
		List<String> list=new ArrayList<String>();
		for(String h:hids){
			list.add(h);
		}
		try {
			handoverBiz.delmanyHandover(list);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
		
	}
	
	//前台查询
		@RequestMapping("findhandover.action")
		@ResponseBody
		public JsonModel findhandover(Handover h,HttpServletRequest request){
			Integer osid=Integer.parseInt(request.getParameter("osid"));
			o.setOsid(osid);
			h.setCar(c);
			h.setDriver(d);
			h.setOrder1(o);
			h.setRoute(r);
			List<Handover> list=new ArrayList<Handover>();
			for(Handover hand:handoverBiz.getHandoverInfo(h))
			{
				if(hand.getHstatus()==0){
					hand.setStatus("未发车");
				}else if(hand.getHstatus()==1){
					hand.setStatus("已发车");
				}else{
					hand.setStatus("以完成");
				}
				hand.setCnumber(hand.getCar().getCnumber());
				hand.setDname(hand.getDriver().getDname());
				hand.setOsid(hand.getOrder1().getOsid());
				hand.setRname(hand.getRoute().getRname());
				hand.setRemark4(String.valueOf(hand.getHid()));
				list.add(hand);
			}
			jsonModel.setCode(1);
			jsonModel.setObj(list);
			return jsonModel;
			
		}
	@RequestMapping("getspname.action")
	@ResponseBody
	public JsonModel getspname(Handover  h,HttpServletRequest request){
		Integer hid =Integer.parseInt(request.getParameter("hid"));
		h.setHid(hid);
		Handover hand=handoverBiz.gethandover(h);
		jsonModel.setCode(1);
		jsonModel.setObj(hand);
		return jsonModel;
		
	}
	@RequestMapping("updatehand.action")
	@ResponseBody
	public JsonModel updatehand(Handover h,HttpServletRequest request) throws ParseException{
		Integer cid=Integer.parseInt(request.getParameter("cnumber"));
		Integer did=Integer.parseInt(request.getParameter("dname"));
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		Integer hstatus=Integer.parseInt(request.getParameter("hstatus"));
		String hremark=request.getParameter("hremark");
		Integer hid=Integer.parseInt(request.getParameter("hid"));
		c.setCid(cid);
		d.setDid(did);
		h.setHid(hid);
		h.setCar(c);
		h.setDriver(d);
		h.setOrder1(o);
		h.setRoute(r);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		h.setHstarttime(sdf.parse(starttime));
		h.setHendtime(sdf.parse(endtime));
		h.setHstatus(hstatus);
		h.setHremark(hremark);
		try {
			handoverBiz.updateHandoverInfo(h);
		} catch (Exception e) {
			jsonModel.setCode(0);
			e.printStackTrace();
			return jsonModel;
		}
		jsonModel.setCode(1);
		return jsonModel;
		
	}
	
	/**
	 * 通过osid查询
	 */
	@RequestMapping("selectForOsid.action")
	@ResponseBody
	public JsonModel findhandoverForOsid(Handover h,HttpServletRequest request){
		Integer osid=Integer.parseInt(request.getParameter("osid"));
		h.setOsid(osid);
		h.setRoute(r);
		List<Handover> list=new ArrayList<Handover>();
		List<Handover> list1=handoverBiz.selectForOsid(h);
		String rvia=r.getRvia();
		String rivaname[]=rvia.split("-");
		for(int i=0;i<rivaname.length-1;i++){
		    String rivaname1= rivaname[i];
			String rivaname2=rivaname[i+1];
			for(Handover hand:list1){
				if(hand.getHfromspname().equals(rivaname1)||hand.getHtospname().equals(rivaname2)){
					list.add(hand);
				}
			}
		}
		jsonModel.setCode(1);
		jsonModel.setObj(list);
		return jsonModel;
	}
}
