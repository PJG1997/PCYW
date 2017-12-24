package com.yc.biz;

import java.util.Map;

import com.yc.bean.Admin;
import com.yc.bean.JsonModel;

public interface AdminBiz {
	public Admin login(Admin admin);
	
	public JsonModel<Admin> searchAllUsers(Map<String,Object> map);
	
}
