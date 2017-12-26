package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.JsonModel;
import com.yc.bean.Users;
import com.yc.dao.AdminDao;
@Repository
public class AdminDaoImpl implements AdminDao{
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	
	/**
	 * 查询所有管理员
	 */
	@Override
	public List<Users> searchAllUsers() {
		
		
		
		List<Users> ls = sqlSession.selectList("users.searchAllAdmin");
		
		
		return ls;
	}

	/**
	 * 查询总记录
	 */
	@Override
	public int total() {
		
		return sqlSession.selectOne("users.getTotal");
	}
	
	/**
	 * 添加管理员
	 */
	@Override
	public int addAdmin(Users u) {
		
		return sqlSession.insert("users.insert",u);
	}
	
}
