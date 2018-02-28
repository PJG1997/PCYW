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

@Controller
@Scope(value="prototype")
public class HandoverController {
	@Resource(name="handoverBizImpl")
	private HandoverBiz handoverBiz;
	private JsonModel jsonModel=new JsonModel();
	private Car c=new Car();
	private Driver d=new Driver(); 
	private Order1 o=new Order1();
	private Route r=new Route();
	//查询
	@RequestMapping("findAllhandover.action")
	@ResponseBody
	public Map<String,Object> findAllhandover(Handover h,HttpServletRequest request){
		Map<String,Object> map=new HashMap<String, Object>();
		h.setCar(c);
		h.setDriver(d);
		h.setOrder1(o);
		h.setRoute(r);
		map.put("total", handoverBiz.getHandoverInfo(h).size());
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		h.setPageNo((pageNo-1)*pageSize);
		h.setPageSize(pageSize);
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
		map.put("rows", list);
		return map;
	}
	
	//查看交接单查询
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
	
	
	@RequestMapping("selectInfo.action")
	@ResponseBody
	public Map<String,Object> searchHandoverInfo(Handover h,HttpServletRequest request) throws ParseException{
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		String hstatus = request.getParameter("hstatus");
		String hid=request.getParameter("hid");
		String hstarttime = request.getParameter("hstarttime");
		String hfromspname = request.getParameter("hfromspname");
		String htospname = request.getParameter("htospname");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		h.setHstatus(Integer.parseInt(hstatus));
		h.setHid(Integer.parseInt(hid));
		h.setHstarttime(sdf.parse(hstarttime));
		h.setHfromspname(hfromspname);
		h.setHtospname(htospname);
		
		map.put("total",handoverBiz.getHandoverInfo(h).size());
		map.put("list", handoverBiz.getHandoverInfo(h));
		
		
		
		return map;
		
	}
	
	//修改交接单
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
	//添加
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
	//批量删除
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
}
