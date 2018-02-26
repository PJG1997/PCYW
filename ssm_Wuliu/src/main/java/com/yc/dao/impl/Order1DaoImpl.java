package com.yc.dao.impl;

import java.util.List;

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
	public Integer addOrder1(Order1 order1) {
		return sqlSession.insert("order1.insertSelective", order1);
	}
	
	@Override
	public List<Order1> findAll() {
		return sqlSession.selectList("order1.selectFindAll");
	}

	public Order1 findRid(Order1 order1) {
		return sqlSession.selectOne("order1.selectByPrimaryKey", order1);
	}

	@Override
	public List<Order1> findAllOrderToPage(Order1 order1) {
		return sqlSession.selectList("order1.findOrderWithPage",order1);
	}
	
}