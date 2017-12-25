package com.yc.biz.impl;

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

	@Resource(name="carDaoMybatisImpl")
	private CarDao carDao;

	@Transactional(readOnly=true)
	public Car getCarInfo(Integer id) {
		return carDao.getCarInfo(id);
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
	public void updateCarStatus(Car c) {

		this.carDao.updateCarStatus(c);
	}

	@Override
	public void delCar(Car c) {
		// TODO Auto-generated method stub
		this.carDao.delCar(c);
	}

}
