package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.Users;

public interface AdminBiz {
	
	/**
	 * 查询所有管理员
	 * @return
	 */
	public List<Users> searchAllAdmin(Users users);
	
	public List<Users> searchAllAdminNoPage(Users users);
	
	
	/**
	 * 添加管理员
	 */
	public int addAdmin(Users u);
	
	
	public int deleteAdmin(List list);
	
	
	public int updateAdmin(Users users);
	
	//恢复管理员
	public int updateStatus(Users u);
	
	//管理员登录
	public Users login(Users user);
	
	
}
