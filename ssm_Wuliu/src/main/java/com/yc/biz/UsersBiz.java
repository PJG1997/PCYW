package com.yc.biz;

import java.util.List;
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
	 * 分页
	 * @return
	 */
	public List<Users> searchAllUsers(Users u);
	
	/**
	 * 无分页查询
	 * @param u
	 * @return
	 */
	public List<Users> searchAllUsersNoCondition(Users u);
	
	/**
	 * 添加用户
	 * @param u
	 * @return
	 */
	public int insertUser(Users u);
	
	/**
	 * 修改用户
	 * @param u
	 * @return
	 */
	public int updateUser(Users u);
	
	/**

	 * 批量删除用户信息
	 * @param list
	 * @return
	 */
	public int deleteUsers(List list);
	
	//恢复用户
	public int updateStatus(Users u);
}
