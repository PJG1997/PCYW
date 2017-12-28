package com.yc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Car;
import com.yc.bean.JsonModel;
import com.yc.biz.CarBiz;

@Controller
@Scope(value="prototype")
public class CarController {
	@Resource(name="carBizImpl")
	private CarBiz carBiz;
	private JsonModel jsonModel=new JsonModel();
	
	@RequestMapping(value="../../findAllcar.action")
	public @ResponseBody Map<String,Object> findAllcar(Car c,HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		Integer pageNo=Integer.parseInt(request.getParameter("page"));
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		c.setPageNo((pageNo-1)*pageSize);
		c.setPageSize(pageSize);
		List<Car> list=new ArrayList<Car>();
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
			list.add(car);
		}
		map.put("rows", list);
		map.put("total", carBiz.getCarInfo(c).size());
		return map;
		
	}
	
	@RequestMapping("addcar.action")
	@ResponseBody
	public int addCar(Car c){
		try {
			carBiz.addCar(c);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	@RequestMapping("delcar.action")
	@ResponseBody
	public int updateCarInfo(Car c){
		
		return 1;
		
	}
}
