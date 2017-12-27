package com.yc.biz;

import java.util.List;

import com.yc.bean.Driver;

public interface DriverBiz {

	public int insertDriver(Driver driver);

	public int deleteDriver(List list);

	public int updateDriver(Driver driver);

	public List<Driver> findDriver(Driver driver);
	
	public List<Driver> findDriverNoCondition(Driver driver);
}
