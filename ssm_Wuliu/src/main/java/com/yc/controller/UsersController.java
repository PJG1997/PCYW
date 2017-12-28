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

import com.google.gson.Gson;
import com.yc.bean.JsonModel;
import com.yc.bean.Users;
import com.yc.biz.UsersBiz;

@Controller
@Scope(value="prototype")
public class UsersController {
	@Resource(name="usersBizImpl")
	private UsersBiz usersBiz;
	
	@RequestMapping(value="back/usersLogin.action")
	public @ResponseBody JsonModel UsersLogin(HttpSession session,HttpServletRequest request,Users users){
		JsonModel jsonModel= new JsonModel();
		String code = request.getParameter("code");
		String codes=String.valueOf(session.getAttribute("rand"));
		
		if(code.equals(codes)){
			jsonModel.setCode(1);
			Users u=usersBiz.login(users);
			if(u!=null){
				jsonModel.setCode(2);
				session.setAttribute("uname", u.getUname());
			}else{
				jsonModel.setCode(3);
			}
		}else{
			jsonModel.setCode(0);
		}
		
		return jsonModel;
	}
	
	@RequestMapping(value="findAllUser.action")
	@ResponseBody
	public Map<String,Object> findAllUsersInfo(HttpSession session,HttpServletRequest request){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			map = usersBiz.searchAllUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
}
