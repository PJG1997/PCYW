package com.yc.controller;

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

import com.yc.bean.JsonModel;
import com.yc.bean.Shippoint;
import com.yc.biz.ShippointBiz;

@Controller
@Scope("prototype")
public class ShippointController {

	@Resource(name="shippointBizImpl")
	private ShippointBiz shippointBiz;
	private JsonModel jsonModel=new JsonModel();
	
	@RequestMapping("findAllShippoint.action")
	public @ResponseBody JsonModel findAllShippoint(){
		jsonModel.setObj(shippointBiz.findAllShippoint());
		return jsonModel;
	}
	
	@RequestMapping("findShippoint.action")
	@ResponseBody
	public Map<String,Object> findShippoint(Shippoint sp,HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", shippointBiz.getShippointInfo(sp).size());
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		sp.setPageNo(pageNo);
		sp.setPageSize(pageSize);
		List<Shippoint> list=new ArrayList<Shippoint>();
		for(Shippoint ship:shippointBiz.getShippointInfo(sp)){
			if(ship.getSptype()==0){
				ship.setType("配送点");
			}else{
				ship.setType("代理点");
			}
			ship.setRemark4(String.valueOf(ship.getSpid()));
			list.add(ship);
		}
		map.put("rows", list);
		return map;
		
	}
	@RequestMapping("findShippointOne.action")
	@ResponseBody
	public JsonModel findShippointOne(Shippoint sp){
		jsonModel.setObj(shippointBiz.getShippointInfo(sp));
		return jsonModel;
	}
	
	@RequestMapping("updateshippoint.action")
	@ResponseBody
	public JsonModel updateshippoint(@RequestParam(value="update_insert_spid") Integer spid,
			@RequestParam(value="update_insert_spname") String spname,@RequestParam(value="update_insert_spperson") String spperson,
			@RequestParam(value="update_insert_sptel") String sptel,@RequestParam(value="update_insert_spemail") String spemail,
			@RequestParam(value="update_insert_spaddress") String spaddress,@RequestParam(value="update_insert_sptype") Integer sptype,
			@RequestParam(value="update_insert_sppersontel") String sppersontel,
			@RequestParam(value="update_insert_spfax") String spfax,@RequestParam(value="update_insert_sparea") String sparea,
			@RequestParam(value="update_insert_spremark") String spremark){
				
		Shippoint sp=new Shippoint();
		sp.setSpid(spid);
		sp.setspname(spname);
		sp.setSpperson(spperson);
		sp.setSptel(sptel);
		sp.setSpemail(spemail);
		sp.setSpaddress(spaddress);
		sp.setSptype(sptype);
		sp.setSppersontel(sppersontel);
		sp.setSpfax(spfax);
		sp.setSparea(sparea);
		sp.setSpremark(spremark);
		try {
			shippointBiz.updateShippointInfo(sp);
		} catch (Exception e) {
			e.printStackTrace();
			jsonModel.setCode(0);
			return jsonModel;
		}
		jsonModel.setCode(1);
		return jsonModel;
		
	}
	
	@RequestMapping("addshippoint.action")
	@ResponseBody
	public JsonModel addShippoint(@RequestParam(value="update_insert_spid") Integer spid,
			@RequestParam(value="update_insert_spname") String spname,@RequestParam(value="update_insert_spperson") String spperson,
			@RequestParam(value="update_insert_sptel") String sptel,@RequestParam(value="update_insert_spemail") String spemail,
			@RequestParam(value="update_insert_spaddress") String spaddress,@RequestParam(value="update_insert_sptype") Integer sptype,
			@RequestParam(value="update_insert_sppersontel") String sppersontel,
			@RequestParam(value="update_insert_spfax") String spfax,@RequestParam(value="update_insert_sparea") String sparea,
			@RequestParam(value="update_insert_spremark") String spremark){
		Shippoint sp=new Shippoint();
		sp.setSpid(spid);
		sp.setspname(spname);
		sp.setSpperson(spperson);
		sp.setSptel(sptel);
		sp.setSpemail(spemail);
		sp.setSpaddress(spaddress);
		sp.setSptype(sptype);
		sp.setSppersontel(sppersontel);
		sp.setSpfax(spfax);
		sp.setSparea(sparea);
		sp.setSpremark(spremark);
		
		try {
			shippointBiz.addShippoint(sp);
		} catch (Exception e) {
			e.printStackTrace();
			jsonModel.setCode(0);
			
			return jsonModel;
		}
		jsonModel.setCode(1);
		return jsonModel;
		
	}
	
	@RequestMapping("delshippoint.action")
	@ResponseBody
	public int delShippoint(@Param(value = "spid") String spid){
		String spids[]=spid.split(",");
		List<String> list=new ArrayList<String>();
		for(String s:spids){
			list.add(s);
		}
		try {
			shippointBiz.delmanyShippoint(list);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
}
