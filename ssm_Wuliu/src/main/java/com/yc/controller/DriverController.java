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
	public @ResponseBody Map<String,Object>  findDriver(Driver driver,HttpServletRequest request){
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
	public @ResponseBody int addDriver(Driver driver){
		//从前台传过来的数据是在忙或者是空闲，要把它转为1或者是0
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
	
	//修改司机信息
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
		if("在忙".equals(remark1)){
			driver.setDstatus(1);
		}else{
			driver.setDstatus(0);
		}
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
