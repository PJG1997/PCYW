package com.yc.dao;

import java.util.List;

import com.yc.bean.Car;

public interface CarDao {
	/*
	 * 根据车子的编号查车子的信息*/
	public List<Car> getCarInfo(Car c);
	
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
	 * 根据车子id批量删除车辆*/
	public void delmanyCar(List list);
}
