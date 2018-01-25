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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Driver;
import com.yc.bean.JsonModel;
import com.yc.bean.Users;
import com.yc.biz.AdminBiz;
import com.yc.util.MD5Encryption;

@Controller
@Scope(value="prototype")
public class AdminController {
	@Resource(name="adminBizImpl")
	private AdminBiz adminBiz;
	private JsonModel jsonModel=new JsonModel();
	
	@RequestMapping(value="findAllAdmin.action")
	public @ResponseBody Map<String,Object> findAllAdminInfo(Users users,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		//获取pageNof
		Integer pageNo=Integer.parseInt(request.getParameter("page"));  
		//获取pageSize
		Integer pageSize=Integer.parseInt(request.getParameter("rows"));
		users.setPageNo((pageNo-1)*pageSize);	
		users.setPageSize(pageSize);
		List<Users> list=new ArrayList<Users>();
		for(Users user:adminBiz.searchAllAdmin(users)){
			user.setRemark4(String.valueOf(user.getUsid()));
			list.add(user);
		}

		//easyui必须接受这样的格式,rows和total是必须的
		map.put("rows", list);
		//driverBiz.findDriverNoCondition(driver).size()调用的是带条件,不带分页的查询,这里不能带分页,如果一带分页,total就会等于pageSize
		map.put("total", adminBiz.searchAllAdminNoPage(users).size());

		return map;
	}
	
	@RequestMapping(value="addAdmin.action")
	@ResponseBody
	public int addAdmin(Users users){
		String pwd=MD5Encryption.createPassword(users.getUpwd());
		users.setUpwd(pwd);
		try {
			adminBiz.addAdmin(users);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	@RequestMapping("deleteAdmin.action")
	public @ResponseBody int delAdmin(@Param(value = "usid") String usid){
		//要把did存在list中
		String[] usids=usid.split(",");
		List<String> list=new ArrayList<String>();
		for(String u:usids){
			list.add(u);
		}
		try {
			adminBiz.deleteAdmin(list);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	@RequestMapping("updateAdmin.action")
	public @ResponseBody int updateDriver(@RequestParam(value="admin_update_usid") Integer usid,@RequestParam(value="admin_update_uname") String uname,
			@RequestParam(value="admin_update_urealname") String urealname,@RequestParam(value="admin_update_uaddress") String uaddress,
			@RequestParam(value="admin_update_uphone") String uphone,@RequestParam(value="admin_update_utel") String utel,@RequestParam(value="admin_update_uemail") String uemail){
		Users users=new Users();
		users.setUsid(usid);
		users.setUname(uname);
		users.setUrealname(urealname);
		users.setUaddress(uaddress);
		users.setUphone(uphone);
		users.setUtel(utel);
		users.setUemail(uemail);
		try {
			adminBiz.updateAdmin(users);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	
	
	@RequestMapping("findAdminInfo.action")
	public @ResponseBody JsonModel findAdriveInfo(Users users){
		JsonModel jsonModel=new JsonModel();
		jsonModel.setObj(adminBiz.searchAllAdmin(users));
		return jsonModel;
	}
	
	@RequestMapping("findAllAdmin2.action")
	public @ResponseBody JsonModel findAllAdmin2(Users users){
		JsonModel jsonModel=new JsonModel();
		List<Users> list = adminBiz.searchAllAdmin(users);
		jsonModel.setCode(1);
		jsonModel.setObj(list);
		return jsonModel;
	}
}