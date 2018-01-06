package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Proxy;
import com.yc.dao.PriceDao;
import com.yc.dao.ProxyDao;

@Repository
public class ProxyDaoImpl implements ProxyDao{

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	@Override
	public int insertProxy(Proxy proxy) {
		return this.sqlSession.insert("proxy.insertSelective", proxy);
	}

	@Override
	public int deleteProxy(List list) {
		return this.sqlSession.update("proxy.deleteByPrimaryKey", list);
	}

	@Override
	public int updateProxy(Proxy proxy) {
		return this.sqlSession.update("proxy.updateByPrimaryKeySelective", proxy);
	}
	
	//带分页
	@Override
	public List<Proxy> findProxy(Proxy proxy) {
		return this.sqlSession.selectList("proxy.selectByPrimaryKeyforPage", proxy);
	}
	
	//不带分页
	@Override
	public List<Proxy> findProxyNoCondition(Proxy proxy) {
		return this.sqlSession.selectList("proxy.selectByPrimaryKey", proxy);
	}

}
