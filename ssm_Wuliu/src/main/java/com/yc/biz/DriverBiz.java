package com.yc.biz;

import java.util.List;

import com.yc.bean.Driver;

public interface DriverBiz {

	
	/**
	 * 添加司机信息
	 * @param driver
	 * @return
	 */
	public int insertDriver(Driver driver);

	
	/**
	 * 批量删除司机信息
	 * @param list
	 * @return
	 */
	public int deleteDriver(List list);

	/**
	 * 修改司机信息
	 * @param driver
	 * @return
	 */
	public int updateDriver(Driver driver);

	
	/**
	 * 带条件，带分页的查询
	 * @param driver
	 * @return
	 */
	public List<Driver> findDriver(Driver driver);
	
	/**
	 * 带条件,不带分页的查询
	 * @param driver
	 * @return
	 */
	public List<Driver> findDriverNoCondition(Driver driver);
}
