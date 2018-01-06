package com.yc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Driver;
import com.yc.bean.JsonModel;
import com.yc.bean.Users;
import com.yc.biz.UsersBiz;
import com.yc.util.MD5Encryption;

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
			String pwd=MD5Encryption.createPassword(users.getUpwd());
			users.setUpwd(pwd);
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
	public Map<String,Object> findAllUsersInfo(HttpSession session,HttpServletRequest request,Users u){
		Map<String,Object> map = new HashMap<String,Object>();
		//获取pageNo
		Integer pageNo=Integer.parseInt(request.getParameter("page"));  
		//获取pageSize
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		u.setPageNo((pageNo-1)*pageSize);	
		u.setPageSize(pageSize);
		u.setStatus(2);
		List<Users> list=new ArrayList<Users>();
		for(Users user:usersBiz.searchAllUsers(u)){
			user.setRemark4(String.valueOf(user.getUsid()));
			list.add(user);
		}

		//easyui必须接受这样的格式,rows和total是必须的
		map.put("rows", list);
		//driverBiz.findDriverNoCondition(driver).size()调用的是带条件,不带分页的查询,这里不能带分页,如果一带分页,total就会等于pageSize
		map.put("total", usersBiz.searchAllUsersNoCondition(u).size());

		return map;
	}
	@RequestMapping(value="findUsersInfo.action")
	@ResponseBody
	public Map<String,Object> findUsersInfoByUsid(HttpSession session,HttpServletRequest request){
		Integer usid = Integer.parseInt(request.getParameter("usid"));
		Users u =new Users();
		u.setUsid(usid);
		List<Users> list=new ArrayList<Users>();
		list = usersBiz.searchAllUsers(u);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", 1);
		map.put("rows", list);
		return map;

	}

	@RequestMapping(value="addUser.action")
	@ResponseBody
	public JsonModel addUser(HttpSession session,HttpServletRequest request){
		JsonModel jsonModel= new JsonModel();
		Users u = new Users();
		u.setUname(request.getParameter("uname"));
		u.setUpwd("31151D398A3508AC");
		u.setUrealname(request.getParameter("urealname"));
		u.setUaddress(request.getParameter("uaddress"));
		u.setUphone(request.getParameter("uphone"));
		u.setUtel(request.getParameter("utel"));
		u.setUemail(request.getParameter("uemail"));
		u.setStatus(2);

		int result = usersBiz.insertUser(u);

		if(result>0){
			jsonModel.setCode(1);
		}else{
			jsonModel.setCode(0);
		}
		return jsonModel;
	}

	@RequestMapping(value="updateUser.action")
	@ResponseBody
	public JsonModel updateUsers(HttpSession session,HttpServletRequest request){
		JsonModel jsonModel = new JsonModel();

		Users u = new Users();
		u.setUsid(Integer.parseInt(request.getParameter("usid")));
		u.setUname(request.getParameter("uname"));
		u.setUrealname(request.getParameter("urealname"));
		u.setUaddress(request.getParameter("uaddress"));
		u.setUphone(request.getParameter("uphone"));
		u.setUtel(request.getParameter("utel"));
		u.setUemail(request.getParameter("uemail"));

		int result =usersBiz.updateUser(u);
		if(result>0){
			jsonModel.setCode(1);
		}else{
			jsonModel.setCode(0);
		}
		return jsonModel;
	}

	//批量删除用户信息
	@RequestMapping("deleteUsers.action")
	public @ResponseBody int delDriver(@Param(value = "usid") String usid){
		//要把did存在list中
		String[] usids=usid.split(",");
		List<String> list=new ArrayList<String>();
		for(String u:usids){
			list.add(u);
		}
		try {
			usersBiz.deleteUsers(list);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

}
