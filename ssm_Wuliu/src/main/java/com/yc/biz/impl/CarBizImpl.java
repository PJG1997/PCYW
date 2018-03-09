package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Car;
import com.yc.biz.CarBiz;
import com.yc.dao.CarDao;

@Service
@Transactional(readOnly=false,isolation=Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)
public class CarBizImpl implements CarBiz {

	@Resource(name="carDaoImpl")
	private CarDao carDao;

	@Override
	@Transactional(readOnly=true)
	public List<Car> getCarInfo(Car c) {
		return carDao.getCarInfo(c);
	}

	@Override
	public void addCar(Car c) {

		this.carDao.addCar(c);
	}

	@Override
	public void updateCarInfo(Car c) {

		this.carDao.updateCarInfo(c);
	}

	@Override
	public void updateCarStatus0(Car c) {

		this.carDao.updateCarStatus0(c);
	}
	
	public void updateCarStatus1(Car c) {

		this.carDao.updateCarStatus1(c);
	}

	@Override
	public void delmanyCar(List list) {
		this.carDao.delmanyCar(list);
	}

	@Override
	public List<Car> getCarNomission(Car c) {
		return carDao.getCarNomission(c);
	}


}
