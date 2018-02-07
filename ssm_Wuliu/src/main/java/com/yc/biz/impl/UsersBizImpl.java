package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Users;
import com.yc.biz.UsersBiz;
import com.yc.dao.UsersDao;


@Service
@Transactional(isolation=Isolation.DEFAULT,rollbackForClassName="java.lang.RuntimeException")
public class UsersBizImpl implements UsersBiz{
	@Resource(name="usersDaoImpl")
	private UsersDao usersDao;
	@Override
	public Users login(Users user) {
		return usersDao.login(user);
	}
	/**
	 * 分页
	 */
	@Override
	public List<Users> searchAllUsers(Users u) {
		return usersDao.searchAllUsers(u);
	}
	@Override
	public int insertUser(Users u) {
		
		return usersDao.insertUser(u);
		
	}
	/**
	 * 无分页
	 */
	@Override
	public List<Users> searchAllUsersNoCondition(Users u) {
		
		return usersDao.searchAllUsersNoCondition(u);
	}
	/**
	 * 修改用户
	 */
	@Override
	public int updateUser(Users u) {
		return usersDao.updateUser(u);
	}

	@Override
	public int deleteUsers(List list) {
		return usersDao.deleteUsers(list);
	}
	@Override
	public int updateStatus(Users u) {
		return usersDao.updateStatus(u);
	}

}
