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
	 * @param user分页
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
	 * 查询总记录数
	 * @return
	 */
	public int total();
	
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
