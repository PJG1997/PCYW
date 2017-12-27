package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.JsonModel;
import com.yc.bean.Users;

public interface AdminDao {
	
	public List<Users> searchAllUsers(Map<String,Object> map); //查询所有管理员信息
	
}
