package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Route;
import com.yc.biz.RouteBiz;
import com.yc.dao.RouteDao;

@Service
@Transactional(isolation=Isolation.DEFAULT,rollbackForClassName="java.lang.RuntimeException")
public class RouteBizImpl implements RouteBiz{
	@Resource(name="routeDaoImpl")
	private RouteDao routeDao;
	
	/**
	 * 添加
	 */
	@Override
	public void addRoute(Route route) {
		this.routeDao.addRoute(route);
	}
	
	/**
	 * 查询
	 */
	@Override
	public List<Route> selectRoute(Route route) {
		return this.routeDao.selectRoute(route);
	}
	
	/**
	 * 删除
	 */
	@Override
	public void deleteRoute(List list) {
		this.routeDao.deleteRoute(list);
	}
	
	/**
	 * 修改
	 */
	@Override
	public void updateRoute(Route route) {
		this.routeDao.updateRoute(route);
	}
	
	/**
	 * 分页 查询
	 */
	@Override
	public List<Route> selectRouteForPage(Route route) {
		return this.routeDao.selectRouteForPage(route);
	}

	@Override
	public Route findRvia(Route route) {
		return routeDao.findRvia(route);
	}

}
