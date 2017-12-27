package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.JsonModel;
import com.yc.bean.Users;

public interface AdminDao {
	
	
	/**
	 * 查询所有管理员
	 * @return
	 */
	public List<Users> searchAllUsers();
	
	
	/**
	 * 查询总记录数
	 * @return
	 */
	public int total();
	
	/**
	 * 添加管理员
	 * @return
	 */
	public int addAdmin(Users u);
	
	public List<Users> searchAllUsers(Map<String,Object> map); //查询所有管理员信息
	
}
