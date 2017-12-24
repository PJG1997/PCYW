package com.yc.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Admin;
import com.yc.dao.AdminDao;
@Repository
public class AdminDaoImpl implements AdminDao{
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	@Override
	public Admin login(Admin admin) {
		return sqlSession.selectOne("com.yc.dao.AdminMybatisMapper.getAdminByLogin", admin);
	}
	
}
