package com.yc.dao;

import com.yc.bean.Car;

public interface CarDao {
	/*
	 * 根据车子的编号查车子的信息*/
	public Car getCarInfo(Integer id);
	
	/*
	 * 添加车子的信息*/
	public void addCar(Car c);
	
	/*
	 * 更新车子的信息*/
	public void updateCarInfo(Car c);
	
	/*
	 * 更新车子的空闲状态*/
	public void updateCarStatus(Car c);
	
	/*
	 * 根据车子的id删除车子*/
	public void delCar(Car c);
}
