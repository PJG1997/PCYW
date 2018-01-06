package com.yc.dao;

import java.util.List;

import com.yc.bean.Proxy;

public interface ProxyDao {
	/**
	 * 添加信息
	 * @param 
	 * @return
	 */
	public int insertProxy(Proxy proxy);
	
	/**
	 * 批量删除代理点信息
	 * @param list
	 * @return
	 */
	public int deleteProxy(List list);
	
	/**
	 * 修改代理点信息
	 * @param 
	 * @return
	 */
	public int updateProxy(Proxy proxy);
	
	/**
	 * 带条件，带分页的查询
	 * @param 
	 * @return
	 */
	public List<Proxy> findProxy(Proxy proxy);
	
	
	/**
	 * 带条件,不带分页的查询
	 * @param 
	 * @return
	 */
	public List<Proxy> findProxyNoCondition(Proxy proxy);
}
