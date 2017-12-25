package com.yc.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Car;
import com.yc.dao.CarDao;

@Repository
public class CarDaoMybatisImpl implements CarDao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Car getCarInfo(Integer cid) {
		return this.sqlSession.selectOne("com.yc.bean.CarMapper.getCarInfo", cid);
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
	public void delCar(Car c) {

		this.sqlSession.delete("com.yc.bean.CarMapper.delCar", c);
	}

}
