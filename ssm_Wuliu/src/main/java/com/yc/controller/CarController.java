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
import com.yc.bean.JsonModel;
import com.yc.bean.Shippoint;
import com.yc.biz.CarBiz;

@Controller
@Scope(value="prototype")
public class CarController {
	@Resource(name="carBizImpl")
	private CarBiz carBiz;
	private JsonModel jsonModel=new JsonModel();
	private Shippoint sp=new Shippoint();
	//查询
	@RequestMapping(value="findAllcar.action")
	public @ResponseBody Map<String,Object> findAllcar(Car c,HttpServletRequest request,@RequestParam(value="spid") Integer spid){
		Map<String,Object> map=new HashMap<String,Object>();
		sp.setSpid(spid);
		c.setShipPoint(sp);
		map.put("total", carBiz.getCarInfo(c).size());
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		c.setPageNo((pageNo-1)*pageSize);
		c.setPageSize(pageSize);
		List<Car> list2=new ArrayList<Car>();
		for(Car car:carBiz.getCarInfo(c))
		{
			if(car.getCstatus()==0){
				car.setStatus("空闲");
			}else{
				car.setStatus("在途中");
			}
			if(car.getCisbox()==0){
				car.setBox("有箱");
			}else{
				car.setBox("无箱");
			}
			car.setRemark3(car.getShipPoint().getspname());
			car.setRemark4(String.valueOf(car.getCid()));
			list2.add(car);
		}
		map.put("rows", list2);
		
		return map;
		
	}
	//添加
	@RequestMapping("addcar.action")
	@ResponseBody
	public JsonModel addCar(@RequestParam(value="update_insert_cid") Integer cid,
			@RequestParam(value="update_insert_spid") Integer spid,@RequestParam(value="update_insert_cnumber") String cnumber,
			@RequestParam(value="update_insert_ctype") String ctype,@RequestParam(value="update_insert_cbuyday") Date cbuyday,
			@RequestParam(value="update_insert_crunnum") String crunnum,@RequestParam(value="update_insert_cvolume") Double cvolume,
			@RequestParam(value="update_insert_cton") Double cton,@RequestParam(value="update_insert_cstatus") Integer cstatus,
			@RequestParam(value="update_insert_cisbox") Integer cisbox,@RequestParam(value="update_insert_cremake") String cremake){
		try {
			Car c=new Car();
			sp.setSpid(spid);
			c.setShipPoint(sp);
			c.setCid(cid);
			c.setCnumber(cnumber);
			c.setCtype(ctype);
			c.setCbuyday(cbuyday);
			c.setCrunnum(crunnum);
			c.setCvolume(cvolume);
			c.setCton(cton);
			c.setCisbox(cisbox);
			c.setCstatus(cstatus);
			c.setCremake(cremake);
			carBiz.addCar(c);
		} catch (Exception e) {
			e.printStackTrace();
			jsonModel.setCode(0);
			
			return jsonModel;
		}
		jsonModel.setCode(1);
		return jsonModel;
	}
	//批量删除
	@RequestMapping("delcar.action")
	@ResponseBody
	public int delCar(@Param(value = "cid") String cid){
		String cids[]=cid.split(",");
		List<String> list=new ArrayList<String>();
		for(String c:cids){
			list.add(c);
		}
		try {
			carBiz.delmanyCar(list);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
		
	}
	//
	@RequestMapping("updatecar.action")
	@ResponseBody
	public JsonModel updateCarInfo(@RequestParam(value="update_insert_cid") Integer cid,
			@RequestParam(value="update_insert_spid") Integer spid,@RequestParam(value="update_insert_cnumber") String cnumber,
			@RequestParam(value="update_insert_ctype") String ctype,@RequestParam(value="update_insert_cbuyday") String buyday,
			@RequestParam(value="update_insert_crunnum") String crunnum,@RequestParam(value="update_insert_cvolume") Double cvolume,
			@RequestParam(value="update_insert_cton") Double cton,@RequestParam(value="update_insert_cstatus") Integer cstatus,
			@RequestParam(value="update_insert_cisbox") Integer cisbox,@RequestParam(value="update_insert_cremake") String cremake) throws ParseException{
		Car c=new Car();
		sp.setSpid(spid);
		c.setCid(cid);
		c.setCnumber(cnumber);
		c.setCtype(ctype);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		c.setCbuyday(sdf.parse(buyday));
		c.setCrunnum(crunnum);
		c.setCvolume(cvolume);
		c.setCton(cton);
		c.setCstatus(cstatus);
		c.setCisbox(cisbox);
		c.setCremake(cremake);
		c.setShipPoint(sp);
		try {
			
			carBiz.updateCarInfo(c);
		} catch (Exception e) {
			e.printStackTrace();
			jsonModel.setCode(0);
			return jsonModel;
		}
		jsonModel.setCode(1);
		return jsonModel;
	}
	
	//查看车辆详情
	@RequestMapping("findCarInfo.action")
	@ResponseBody
	public JsonModel findCarInfo(Car car){
		car.setShipPoint(sp);
		jsonModel.setObj(carBiz.getCarInfo(car));
		return jsonModel;
	}
}
