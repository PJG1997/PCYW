package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Shippoint;
import com.yc.dao.ShippointDao;

@Repository
public class ShippointDaoImpl implements ShippointDao{

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Shippoint> findAllShippoint() {
		return sqlSession.selectList("shippoint.findAllShippoint");
	}

}
