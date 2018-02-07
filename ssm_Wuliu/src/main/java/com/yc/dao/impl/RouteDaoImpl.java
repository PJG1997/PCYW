package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.Goods;
import com.yc.bean.Route;
import com.yc.dao.RouteDao;

@Repository
public class RouteDaoImpl implements RouteDao{
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 添加路线
	 */
	@Override
	public void addRoute(Route route) {
		this.sqlSession.insert("route.insert", route);
	}
	
	/**
	 * 查询 （带条件和不带条件）不带分页
	 */
	@Override
	public List<Route> selectRoute(Route route) {
		return this.sqlSession.selectList("route.selectByPrimaryKey", route);
	}
	
	/**
	 * 删除（修改状态）
	 */
	@Override
	public void deleteRoute(List list) {
		this.sqlSession.update("route.deleteByPrimaryKey",list);
	}
	
	/**
	 * 修改
	 */
	@Override
	public void updateRoute(Route route) {
		this.sqlSession.update("route.updateByPrimaryKey", route);
	}
	
	/**
	 * 带分页查询
	 */
	@Override
	public List<Route> selectRouteForPage(Route route) {
		return this.sqlSession.selectList("route.selectByPrimaryKeyforPage", route);
	}
	/*
	 * 查路线顺序*/

	@Override
	public Route findRvia(Route route) {
		
		return sqlSession.selectOne("route.selectByPrimaryKeyrvia", route);
	}
	

}
