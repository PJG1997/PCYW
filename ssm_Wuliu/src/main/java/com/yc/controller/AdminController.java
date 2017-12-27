package com.yc.controller;

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
	public JsonModel addAdmin(HttpSession session,HttpServletRequest request){
		
		try {
			Users u = new Users();
			u.setUsid(1);
			u.setUname(request.getParameter("uname"));
			u.setUpwd(request.getParameter("upwd"));
			u.setUrealname(request.getParameter("urealname"));
			u.setUaddress(request.getParameter("uaddress"));
			u.setUphone(request.getParameter("uphone"));
			u.setUtel(request.getParameter("utel"));
			u.setUemail(request.getParameter("uemail"));
			u.setStatus(1);
			
			int result=adminBiz.addAdmin(u);
			jsonModel.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonModel.setCode(0);
			
		}
		return jsonModel;
		
	}
}
