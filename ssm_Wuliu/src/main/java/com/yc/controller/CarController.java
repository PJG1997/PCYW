package com.yc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
	
	@RequestMapping(value="findAllcar.action")
	public @ResponseBody Map<String,Object> findAllcar(Car c){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Car> list=new ArrayList<Car>();
		List<Car> rows=carBiz.getCarInfo(c);
		for(Car car:rows){
			car.setRemark3(car.getShipPoint().getspname());
			list.add(car);
		}
		int total=list.size();
		map.put("total", total);
		map.put("rows", list);
		return map;
		
	}
}
