package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Shippoint;
import com.yc.dao.ShippointDao;

@Repository
public class ShippointDaoImpl implements ShippointDao{

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Shippoint> findAllShippoint() {
		return this.sqlSession.selectList("com.yc.bean.ShippointMapper.findAllShippoint");
	}

	@Override
	public List<Shippoint> getShippointInfo(Shippoint sp) {
		return this.sqlSession.selectList("com.yc.bean.ShippointMapper.selectByPrimaryKey", sp);
	}

	@Override
	public void updateShippointInfo(Shippoint sp) {
		this.sqlSession.update("com.yc.bean.ShippointMapper.updateByPrimaryKeySelective", sp);
	}

	@Override
	public void delmanyShippoint(List list) {
		this.sqlSession.update("com.yc.bean.ShippointMapper.delmanyShippoint", list);
	}

	@Override
	public void addShippoint(Shippoint sp) {
		this.sqlSession.insert("com.yc.bean.ShippointMapper.insert", sp);
	}

	@Override
	public Shippoint getShippoint(Shippoint sp) {
		
		return sqlSession.selectOne("com.yc.bean.ShippointMapper.selectBySpname", sp);
	}

}
