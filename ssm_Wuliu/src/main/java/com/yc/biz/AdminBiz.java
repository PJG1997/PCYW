package com.yc.biz;

import java.util.Map;

import com.yc.bean.JsonModel;
import com.yc.bean.Users;

public interface AdminBiz {
	
	public JsonModel<Users> searchAllUsers(Map<String,Object> map);
	
}
