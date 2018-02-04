package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.Users;

public interface AdminDao {
	
	
	/**
	 * 查询所有管理员
	 * @return
	 */
	public List<Users> searchAllAdmin(Users users);
	
	public List<Users> searchAllAdminNoPage(Users users);
	
	
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
	
	
	public int deleteAdmin(List list);
	
	
	public int updateAdmin(Users users);
	
	//恢复管理员
	public int updateStatus(Users u);
	
}
