package com.yc.biz.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.JsonModel;
import com.yc.bean.Users;
import com.yc.biz.AdminBiz;
import com.yc.dao.AdminDao;
@Service
@Transactional(readOnly=true)
public class AdminBizImpl implements AdminBiz{
	@Resource(name="adminDaoImpl")
	private AdminDao adminDao;
	
	
	
	@Override
	public JsonModel<Users> searchAllUsers(Map<String, Object> map) {
		
		
		return adminDao.searchAllUsers(map);
	}

	
	
}
