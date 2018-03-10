package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Car;
import com.yc.bean.Driver;
import com.yc.dao.DriverDao;

@Repository
public class DriverDaoImpl implements DriverDao{

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 添加司机信息
	 * @param driver
	 * @return
	 */
	@Override
	public int insertDriver(Driver driver) {
		return sqlSession.insert("driver.insertSelective", driver);
	}

	/**
	 * 批量删除司机信息
	 * @param list
	 * @return
	 */
	@Override
	public int deleteDriver(List list) {
		return sqlSession.delete("driver.deleteByPrimaryKey", list);
	}

	/**
	 * 修改司机信息
	 * @param driver
	 * @return
	 */
	@Override
	public int updateDriver(Driver driver) {
		return sqlSession.update("driver.updateByPrimaryKeySelective", driver);
	}

	/**
	 * 带条件，带分页的查询
	 * @param driver
	 * @return
	 */
	@Override
	public List<Driver> findDriver(Driver driver) {
		return sqlSession.selectList("driver.selectByPrimaryKey", driver);
	}

	/**
	 * 带条件,不带分页的查询
	 * @param driver
	 * @return
	 */
	@Override
	public List<Driver> findDriverNoCondition(Driver driver) {
		return sqlSession.selectList("driver.selectDriverNoCondition",driver);
	}

	@Override
	public List<Driver> findDriverNomission(Driver driver) {
		return sqlSession.selectList("driver.selectDriverNomission",driver);
	}

	@Override
	public void updateDriverStatus0(Driver d) {
		this.sqlSession.update("driver.updateDriverStatus0", d);
	}

	@Override
	public void updateDriverStatus1(Driver d) {
		this.sqlSession.update("driver.updateDriverStatus1", d);
	}
}
