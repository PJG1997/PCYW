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
	
	@Override
	public int insertDriver(Driver driver) {
		return driverDao.insertDriver(driver);
	}

	@Override
	public int deleteDriver(List list) {
		return driverDao.deleteDriver(list);
	}

	@Override
	public int updateDriver(Driver driver) {
		return driverDao.updateDriver(driver);
	}

	@Override
	public List<Driver> findDriver(Driver driver) {
		return driverDao.findDriver(driver);
	}

	@Override
	public List<Driver> findDriverNoCondition(Driver driver) {
		return driverDao.findDriverNoCondition(driver);
	}

}
