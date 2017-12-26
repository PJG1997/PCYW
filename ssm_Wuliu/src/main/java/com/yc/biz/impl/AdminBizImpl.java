package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
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
	public Map<String, Object> searchAllUsers() {
		List<Users> ls = adminDao.searchAllUsers();
		Map<String,Object> maps = new HashMap<String,Object>();
		int result = adminDao.total();
		maps.put("total", result);
		maps.put("rows", ls);
		
		return maps;
	}

	
	
}
