package com.yc.biz;

import java.util.Map;

import com.yc.bean.Users;

public interface UsersBiz {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public Users login(Users user);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public Map<String,Object> searchAllUsers();
	
}
