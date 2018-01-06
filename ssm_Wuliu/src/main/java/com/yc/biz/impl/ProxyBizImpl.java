package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Proxy;
import com.yc.biz.ProxyBiz;
import com.yc.dao.ProxyDao;

@Service
@Transactional(isolation=Isolation.DEFAULT,rollbackForClassName="java.lang.RuntimeException")
public class ProxyBizImpl implements ProxyBiz{
	@Resource(name="proxyDaoImpl")
	private ProxyDao proxyDao;
	//添加
	@Override
	public int insertProxy(Proxy proxy) {
		return this.proxyDao.insertProxy(proxy);
	}
	//删除
	@Override
	public int deleteProxy(List list) {
		return this.proxyDao.deleteProxy(list);
	}
	//修改
	@Override
	public int updateProxy(Proxy proxy) {
		return this.proxyDao.updateProxy(proxy);
	}
	//带分页查询
	@Override
	public List<Proxy> findProxy(Proxy proxy) {
		return this.proxyDao.findProxy(proxy);
	}
	//不带分页查询
	@Override
	public List<Proxy> findProxyNoCondition(Proxy proxy) {
		return this.proxyDao.findProxyNoCondition(proxy);
	}

}
