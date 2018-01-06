package com.yc.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Order1;
import com.yc.dao.Order1Dao;

@Repository
public class Order1DaoImpl implements Order1Dao{

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int addOrder1(Order1 order1) {
		return sqlSession.insert("order1.insertSelective", order1);
	}

}
