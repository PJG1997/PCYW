package com.yc.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Car;
import com.yc.bean.JsonModel;
import com.yc.biz.Order1Biz;

@Controller
@Scope(value="prototype")
public class Order1Controller {
	@Resource(name="order1BizImpl")
	private Order1Biz order1Biz;
	private JsonModel jsonModel=new JsonModel();
	
	@RequestMapping("findAllo.action")
	@ResponseBody
	public JsonModel findAll(){
		jsonModel.setObj(order1Biz.findAll());
		return jsonModel;
		
	}
}
