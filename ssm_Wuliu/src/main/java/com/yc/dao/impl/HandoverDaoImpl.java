package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Car;
import com.yc.bean.Handover;
import com.yc.dao.HandoverDao;

@Repository
public class HandoverDaoImpl implements HandoverDao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Handover> getHandoverInfo(Handover h) {
		return this.sqlSession.selectList("com.yc.bean.HandoverMapper.selectHandorderInfo", h);
	}

	@Override
	public void addHandover(Handover h) {
		this.sqlSession.insert("com.yc.bean.HandoverMapper.insertSelective", h);
	}

	@Override
	public void updateHandoverInfo(Handover h) {
		this.sqlSession.update("com.yc.bean.HandoverMapper.updateByPrimaryKeySelective", h);

	}

	@Override
	public void delmanyHandover(List list) {
		// TODO Auto-generated method stub
		this.sqlSession.update("com.yc.bean.HandoverMapper.delmanyHandover", list);
	}

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}