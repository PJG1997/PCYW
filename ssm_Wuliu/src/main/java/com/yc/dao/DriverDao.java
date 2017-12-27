package com.yc.dao;

import java.util.List;

import com.yc.bean.Driver;

public interface DriverDao {
	
	public int insertDriver(Driver driver);
	
	public int deleteDriver(List list);
	
	public int updateDriver(Driver driver);
	
	public List<Driver> findDriver(Driver driver);
	
	
	public List<Driver> findDriverNoCondition(Driver driver);
}
