package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Admin;
import com.yc.bean.JsonModel;
import com.yc.dao.AdminDao;
@Repository
public class AdminDaoImpl implements AdminDao{
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	@Override
	public Admin login(Admin admin) {
		return sqlSession.selectOne("com.yc.dao.AdminMybatisMapper.getAdminByLogin", admin);
	}
	@Override
	public JsonModel searchAllUsers(Map<String, Object> map) {
		JsonModel<Admin> jsonModel = new JsonModel<Admin>();
		
		List<Admin> ls = sqlSession.selectList("com.yc.dao.AdminMybatisMapper.searchAllAdmin0",map);
		
		jsonModel.setUsers(ls);
		
		return jsonModel;
	}
	
}
