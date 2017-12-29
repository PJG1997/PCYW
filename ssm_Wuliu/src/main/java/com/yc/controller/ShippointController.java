package com.yc.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.JsonModel;
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
	
}
