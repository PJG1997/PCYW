package com.yc.dao;

import java.util.Map;

import com.yc.bean.Admin;
import com.yc.bean.JsonModel;

public interface AdminDao {
	public Admin login(Admin admin);
	
	public JsonModel<Admin> searchAllUsers(Map<String,Object> map); //查询所有管理员信息
	
}
