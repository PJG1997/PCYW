package com.yc.biz;

import java.util.Map;

import com.yc.bean.JsonModel;
import com.yc.bean.Users;

public interface AdminBiz {
	
	/**
	 * 查询所有管理员
	 * @return
	 */
	public Map<String,Object> searchAllUsers();
	
	
	/**
	 * 添加管理员
	 */
	public int addAdmin(Users u);
	
}
