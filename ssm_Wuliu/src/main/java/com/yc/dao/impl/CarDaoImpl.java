package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Car;
import com.yc.dao.CarDao;

@Repository
public class CarDaoImpl implements CarDao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	
	
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Car> getCarInfo(Car c) {
		return this.sqlSession.selectList("com.yc.bean.CarMapper.getCarInfo", c);
	}

	@Override
	public void addCar(Car c) {

		this.sqlSession.insert("com.yc.bean.CarMapper.addCar", c);
	}

	@Override
	public void updateCarInfo(Car c) {

		this.sqlSession.update("com.yc.bean.CarMapper.updateCarInfo", c);
	}

	@Override
	public void updateCarStatus0(Car c) {

		this.sqlSession.update("com.yc.bean.CarMapper.updateCarStatus0", c);
	}

	public void updateCarStatus1(Car c) {

		this.sqlSession.update("com.yc.bean.CarMapper.updateCarStatus1", c);
	}
	@Override
	public void delmanyCar(List list) {

		this.sqlSession.update("com.yc.bean.CarMapper.delmanyCar", list);
	}

	@Override
	public List<Car> getCarNomission(Car c) {
		return this.sqlSession.selectList("com.yc.bean.CarMapper.getCarNomission", c);
	}

}
