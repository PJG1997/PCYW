package com.yc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Admin;
import com.yc.bean.JsonModel;
import com.yc.biz.AdminBiz;

@Controller
@Scope(value="prototype")
public class AdminController {
	@Resource(name="adminBizImpl")
	private AdminBiz adminBiz;
	private JsonModel jsonModel=new JsonModel();
	
	@RequestMapping(value="adminLogin.action")
	public @ResponseBody JsonModel UsersLogin(HttpSession session,HttpServletRequest request,Admin admin){
		String code = request.getParameter("code");
		String codes=String.valueOf(session.getAttribute("rand"));
	
		if(code.equals(codes)){
			jsonModel.setCode(1);
			Admin u=adminBiz.login(admin);
			if(u!=null){
				jsonModel.setCode(2);
			}else{
				jsonModel.setCode(3);
			}
		}else{
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
}
