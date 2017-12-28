package com.yc.dao;

import java.util.List;

import com.yc.bean.Users;

public interface UsersDao {
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public Users login(Users user);
	
	/**
	 * 查询所有用户
	 * @param user
	 * @return
	 */
	public List<Users> searchAllUsers();
	
	/**
	 * 查询总记录数
	 * @return
	 */
	public int total();
}
