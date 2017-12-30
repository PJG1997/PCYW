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

import com.yc.bean.Driver;
import com.yc.bean.JsonModel;
import com.yc.bean.Shippoint;
import com.yc.biz.DriverBiz;

@Controller
@Scope("prototype")
public class DriverController {

	@Resource(name="driverBizImpl")
	private DriverBiz driverBiz;
	Map<String,Object> map=new HashMap<String,Object>();
	private Shippoint sp=new Shippoint();
	
	//带条件,带分页查询司机的信息
	@RequestMapping("findAll.action")
	public @ResponseBody Map<String,Object>  findDriver(Driver driver,HttpServletRequest request,@RequestParam(value="spid") Integer spid){
		sp.setSpid(spid);
		driver.setShipPoint(sp);
		//获取pageNo
		Integer pageNo=Integer.parseInt(request.getParameter("page"));  
		//获取pageSize
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		driver.setPageNo((pageNo-1)*pageSize);	//remark1表示pageNo
		driver.setPageSize(pageSize);	//remark2表示pageSize
		List<Driver> list=new ArrayList<Driver>();
		//因为status表示的是1或0  所以需要转换一下,0代表空闲，1代表在忙
		for(Driver d:driverBiz.findDriver(driver)){
			if(d.getDstatus()==0){
				d.setRemark1("空闲");		//暂时用remark1表示空闲
			}else{
				d.setRemark1("在忙");		//暂时用remark1表示在忙
			}
			
			//暂时用remark3存配送点名字
			d.setRemark3(d.getShipPoint().getspname());
			d.setRemark4(String.valueOf(d.getDid()));
			list.add(d);
		}
		
		//easyui必须接受这样的格式,rows和total是必须的
		map.put("rows", list);
		//driverBiz.findDriverNoCondition(driver).size()调用的是带条件,不带分页的查询,这里不能带分页,如果一带分页,total就会等于pageSize
		map.put("total", driverBiz.findDriverNoCondition(driver).size());
		return map;
	}
	
	//添加司机信息
	@RequestMapping("adddriver.action")
	public @ResponseBody int addDriver(Driver driver,@RequestParam(value="spid") Integer spid){
		sp.setSpid(spid);
		driver.setShipPoint(sp);
		try {
			driverBiz.insertDriver(driver);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	//批量删除司机信息
	@RequestMapping("deldriver.action")
	public @ResponseBody int delDriver(@Param(value = "did") String did){
		//要把did存在list中
		String[] dids=did.split(",");
		List<String> list=new ArrayList<String>();
		for(String d:dids){
			list.add(d);
		}
		try {
			driverBiz.deleteDriver(list);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	//修改司机信息:不能直接用对象去接受了
	@RequestMapping("updatedriver.action")
	public @ResponseBody int updateDriver(@RequestParam(value="update_insert_did") Integer did,@RequestParam(value="update_insert_dname") String dname,
			@RequestParam(value="update_insert_spid") Integer spid,@RequestParam(value="update_insert_dnumber") String dnumber,@RequestParam(value="update_insert_dphone") String dphone,
			@RequestParam(value="update_insert_didcard") String didcard,@RequestParam(value="update_insert_ddage") Integer ddage,@RequestParam(value="update_insert_dstatus") Integer dstatus){
		Driver driver=new Driver();
		sp.setSpid(spid);
		driver.setDid(did);
		driver.setDname(dname);
		driver.setDnumber(dnumber);
		driver.setDphone(dphone);
		driver.setDidcard(didcard);
		driver.setDdage(ddage);
		driver.setDstatus(dstatus);
		driver.setShipPoint(sp);
		try {
			driverBiz.updateDriver(driver);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	
	//查询司机详细信息
	@RequestMapping("findAdriveInfo.action")
	public @ResponseBody JsonModel findAdriveInfo(Driver driver){
		driver.setShipPoint(sp);
		JsonModel jsonModel=new JsonModel();
		jsonModel.setObj(driverBiz.findDriverNoCondition(driver));
		return jsonModel;
	}
}
