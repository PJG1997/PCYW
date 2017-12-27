/*package com.yc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.JsonModel;
import com.yc.bean.Users;
import com.yc.biz.AdminBiz;

@Controller
@Scope(value="prototype")
public class AdminController {
	@Resource(name="adminBizImpl")
	private AdminBiz adminBiz;
	private JsonModel<Users> jsonModel=new JsonModel<Users>();
	
	
	
	@RequestMapping(value="findAllAdmin.action")
	@ResponseBody
	public JsonModel findAllAdminInfo(HttpSession session,HttpServletRequest request,Users users){
		
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("Admin",users);
			jsonModel=adminBiz.searchAllUsers(map);
			session.setAttribute("listAdmin", jsonModel.getUsers());
			jsonModel.setCode(1);
		} catch (Exception e) {
			jsonModel.setCode(0);
			e.printStackTrace();
		}
		return jsonModel;
		
	}
}
*/