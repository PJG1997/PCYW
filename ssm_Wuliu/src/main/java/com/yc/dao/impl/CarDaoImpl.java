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
		return this.sqlSession.selectOne("com.yc.bean.CarMapper.getCarInfo", c);
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
	public void updateCarStatus(Car c) {

		this.sqlSession.update("com.yc.bean.CarMapper.updateCarStatus", c);
	}


	@Override
	public void delmanyCar(List<Car> list) {

		this.sqlSession.delete("com.yc.bean.CarMapper.delmanyCar", list);
	}

}
