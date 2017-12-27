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
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Driver;
import com.yc.bean.Shippoint;
import com.yc.biz.DriverBiz;

@Controller
@Scope("prototype")
public class DriverController {

	@Resource(name="driverBizImpl")
	private DriverBiz driverBiz;
	Map<String,Object> map=new HashMap<String,Object>();
	
	@RequestMapping("findAll.action")
	public @ResponseBody Map<String,Object>  findDriver(Driver driver,HttpServletRequest request){
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		driver.setDid((pageNo-1)*pageSize);
		driver.setDdage(pageSize);
		List<Driver> list=new ArrayList<Driver>();
		for(Driver d:driverBiz.findDriver(driver)){
			if(d.getDstatus()==0){
				d.setRemark1("空闲");
			}else{
				d.setRemark1("在忙");
			}
			list.add(d);
		}
		map.put("rows", list);
		map.put("total", driverBiz.findDriverNoCondition(driver).size());
		return map;
	}
	
	@RequestMapping("adddriver.action")
	public @ResponseBody int addDriver(Driver driver){
		if(driver.getRemark1()=="在忙"){
			driver.setDstatus(1);
		}else{
			driver.setDstatus(0);
		}
		
		try {
			driverBiz.insertDriver(driver);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	@RequestMapping("deldriver.action")
	public @ResponseBody int delDriver(@Param(value = "did") String did){
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
	
	@RequestMapping("updatedriver.action")
	public @ResponseBody int updateDriver(@Param(value="did") Integer did,@Param(value="dname") String dname,
			@Param(value="dnumber") String dnumber,@Param(value="dphone") String dphone,
			@Param(value="didcard") String didcard,@Param(value="ddage") Integer ddage,@Param(value="remark1") String remark1){
		Driver driver=new Driver();
		driver.setDid(did);
		driver.setDname(dname);
		driver.setDnumber(dnumber);
		driver.setDphone(dphone);
		driver.setDidcard(didcard);
		driver.setDdage(ddage);
		System.out.println(remark1);
		if("在忙".equals(remark1)){
			driver.setDstatus(1);
		}else{
			driver.setDstatus(0);
		}
		System.out.println(driver);
		try {
			driverBiz.updateDriver(driver);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
}
