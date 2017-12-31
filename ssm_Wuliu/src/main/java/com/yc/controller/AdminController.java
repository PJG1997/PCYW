package com.yc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
	private JsonModel jsonModel=new JsonModel();
	
	@RequestMapping(value="findAllAdmin.action")
	@ResponseBody
	public Map<String,Object> findAllAdminInfo(HttpSession session,HttpServletRequest request,Users users){
		Map<String,Object> maps = new HashMap<String,Object>();
		try {
			
			maps = adminBiz.searchAllUsers();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return maps;
		
	}
	
	@RequestMapping(value="addAdmin.action")
	@ResponseBody
	public Map<String,Object> addAdmin(HttpSession session,HttpServletRequest request){
		
		Map<String,Object> objMap=new HashMap<String,Object>();
		try {
			Users u = new Users();
			
			u.setUname(request.getParameter("uname"));
			u.setUpwd(request.getParameter("upwd"));
			u.setUrealname(request.getParameter("urealname"));
			u.setUaddress(request.getParameter("uaddress"));
			u.setUphone(request.getParameter("uphone"));
			u.setUtel(request.getParameter("utel"));
			u.setUemail(request.getParameter("uemail"));
			u.setStatus(1);
			
			int result=adminBiz.addAdmin(u);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("Admin",u);
			objMap.put("total", 1);
			objMap.put("rows", adminBiz.searchAllUsers(map));
			jsonModel.setCode(1);
			jsonModel.setObj(objMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonModel.setCode(0);
			
		}
		return objMap;
	}
}