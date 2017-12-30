package com.yc.dao;

import java.util.List;

import com.yc.bean.Route;

public interface RouteDao {
	//添加路线
	public void addRoute(Route route);
	//查询不带分页
	public List<Route> selectRoute(Route route);
	//删除
	public void deleteRoute(List list);
	//修改
	public void updateRoute(Route route);
	//带条件 带分页查询
	public List<Route> selectRouteForPage(Route route);
}
