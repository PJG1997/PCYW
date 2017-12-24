package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Admin;
import com.yc.biz.AdminBiz;
import com.yc.dao.AdminDao;
@Service
@Transactional(readOnly=true)
public class AdminBizImpl implements AdminBiz{
	@Resource(name="adminDaoImpl")
	private AdminDao adminDao;
	@Override
	public Admin login(Admin admin) {
		return adminDao.login(admin);
	}

}
