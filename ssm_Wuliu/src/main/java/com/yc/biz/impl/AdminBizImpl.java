package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Users;
import com.yc.biz.AdminBiz;
import com.yc.dao.AdminDao;
@Service
@Transactional(isolation=Isolation.DEFAULT,rollbackForClassName="java.lang.RuntimeException")
public class AdminBizImpl implements AdminBiz{
	@Resource(name="adminDaoImpl")
	private AdminDao adminDao;

	@Override
	public int addAdmin(Users u) {
		
		return adminDao.addAdmin(u);
	}

	@Override
	public int deleteAdmin(List list) {
		return adminDao.deleteAdmin(list);
	}

	@Override
	public List<Users> searchAllAdmin(Users users) {
		return adminDao.searchAllAdmin(users);
	}

	@Override
	public List<Users> searchAllAdminNoPage(Users users) {
		return adminDao.searchAllAdminNoPage(users);
	}

	@Override
	public int updateAdmin(Users users) {
		return adminDao.updateAdmin(users);
	}
	
	//管理员恢复
	@Override
	public int updateStatus(Users u) {
		return adminDao.updateStatus(u);
	}
	//管理员登录
	@Override
	public Users login(Users user) {
		return adminDao.login(user);
	}

}
