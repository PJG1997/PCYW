package com.yc.dao.impl;

import java.util.ArrayList;
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
	
	@Override
	public List<Users> searchAllUsers(Map<String, Object> map) {
		List<Users> ls = sqlSession.selectList("users.searchAllAdmin",map);
		return ls;
	}
	
}
