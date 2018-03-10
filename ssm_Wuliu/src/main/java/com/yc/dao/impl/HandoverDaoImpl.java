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

		return this.sqlSession.selectList("com.yc.bean.HandoverMapper.searchAllHandoverInfo2", h);
	}
	@Override
	public List<Handover> getMoreHandoverInfo(Handover h){
		return this.sqlSession.selectList("com.yc.bean.HandoverMapper.searchAllHandoverInfo",h);
	}
	//分布式查询
	@Override
	public List<Handover> getFirstHandoverInfo(Handover h) {
		return this.sqlSession.selectList("com.yc.bean.HandoverMapper.searchAllHandoverInfo2",h);
	}
	@Override
	public Handover getCnumberByHandover(Handover h) {
		return this.sqlSession.selectOne("com.yc.bean.HandoverMapper.searchCnumberByHandover",h);
	}
	@Override
	public Handover getDnameByHandover(Handover h) {
		return this.sqlSession.selectOne("com.yc.bean.HandoverMapper.searchDnameByHandover",h);
	}
	
	//添加交接单
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
	//只根据hid查信息
	@Override
	public Handover gethandover(Handover h) {
		return sqlSession.selectOne("com.yc.bean.HandoverMapper.selectByPrimaryKey", h);
	}
	@Override
	public List<Handover> selectForOsid(Handover h) {
		return sqlSession.selectList("com.yc.bean.HandoverMapper.searchHandoverForOrderId",h);
	}
	
	
}
