package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Driver;
import com.yc.biz.DriverBiz;
import com.yc.dao.DriverDao;

@Service
@Transactional(isolation=Isolation.DEFAULT,rollbackForClassName="java.lang.RuntimeException")
public class DriverBizImpl implements DriverBiz{

	@Resource(name="driverDaoImpl")
	private DriverDao driverDao;
	
	
	/**
	 * 添加司机信息
	 * @param driver
	 * @return
	 */
	@Override
	public int insertDriver(Driver driver) {
		return driverDao.insertDriver(driver);
	}

	
	/**
	 * 批量删除司机信息
	 * @param list
	 * @return
	 */
	@Override
	public int deleteDriver(List list) {
		return driverDao.deleteDriver(list);
	}

	
	/**
	 * 修改司机信息
	 * @param driver
	 * @return
	 */
	@Override
	public int updateDriver(Driver driver) {
		return driverDao.updateDriver(driver);
	}

	/**
	 * 带条件，带分页的查询
	 * @param driver
	 * @return
	 */
	@Override
	public List<Driver> findDriver(Driver driver) {
		return driverDao.findDriver(driver);
	}

	/**
	 * 带条件,不带分页的查询
	 * @param driver
	 * @return
	 */
	@Override
	public List<Driver> findDriverNoCondition(Driver driver) {
		return driverDao.findDriverNoCondition(driver);
	}

}
