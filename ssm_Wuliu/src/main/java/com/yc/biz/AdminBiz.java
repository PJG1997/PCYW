package com.yc.biz;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 查询所有管理员
	 * @return
	 */
	public List<Users> searchAllUsers(Map<String,Object> map);
	
}
