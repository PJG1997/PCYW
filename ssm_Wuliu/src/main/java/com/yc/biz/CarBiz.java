package com.yc.biz;

import java.util.List;

import com.yc.bean.Car;

public interface CarBiz {
	/*
	 * 根据车子的编号查车子的信息*/
	public List<Car> getCarInfo(Car c);
	
	/*
	 * 查没有任务的司机*/
	public List<Car> getCarNomission(Car c);
	/*
	 * 添加车子的信息*/
	public void addCar(Car c);
	
	/*
	 * 更新车子的信息*/
	public void updateCarInfo(Car c);
	
	/*
	 * 更新车子的空闲状态*/
	public void updateCarStatus0(Car c);
	
	public void updateCarStatus1(Car c);
	/*根据车子id批量删除*/
	public void delmanyCar(List list);
}
