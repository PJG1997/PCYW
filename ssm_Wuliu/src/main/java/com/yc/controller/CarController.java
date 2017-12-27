/*package com.yc.controller;

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
	private JsonModel<Car> jsonModel=new JsonModel<Car>();
	
	@RequestMapping(value="../../findAllcar.action")
	public @ResponseBody Map<String,Object> findAllcar(Car c){
		Map<String,Object> map=new HashMap<String,Object>();
		
		List<Car> rows=carBiz.getCarInfo(c);
		int total=rows.size();
		map.put("total", total);
		map.put("rows", rows);
		return map;
		
	}
}
*/