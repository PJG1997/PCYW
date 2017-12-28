package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Driver;
import com.yc.dao.DriverDao;

@Repository
public class DriverDaoImpl implements DriverDao{

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertDriver(Driver driver) {
		return sqlSession.insert("driver.insertSelective", driver);
	}

	@Override
	public int deleteDriver(List list) {
		return sqlSession.delete("driver.deleteByPrimaryKey", list);
	}

	@Override
	public int updateDriver(Driver driver) {
		return sqlSession.update("driver.updateByPrimaryKeySelective", driver);
	}

	@Override
	public List<Driver> findDriver(Driver driver) {
		return sqlSession.selectList("driver.selectByPrimaryKey", driver);
	}

	@Override
	public List<Driver> findDriverNoCondition(Driver driver) {
		return sqlSession.selectList("driver.selectDriverNoCondition",driver);
	}
}
