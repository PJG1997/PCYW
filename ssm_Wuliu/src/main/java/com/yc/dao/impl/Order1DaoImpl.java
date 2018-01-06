package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Order1;
import com.yc.dao.Order1Dao;
@Repository
public class Order1DaoImpl implements Order1Dao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Order1> findAll() {
		
		return this.sqlSession.selectList("order1.selectFindAll");
	}

}
