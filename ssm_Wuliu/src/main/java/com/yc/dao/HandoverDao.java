package com.yc.dao;

import java.util.List;

import com.yc.bean.Handover;

public interface HandoverDao {
	
	
	/**
	 * 分布式查询：
	 * 思路：先查询出需要的交接单信息再根据信息来补充完善交接单信息
	 * 缺点:数据量大时运算会很慢
	 * @param h
	 * @return
	 */
	public List<Handover> getFirstHandoverInfo(Handover h);
	public Handover getCnumberByHandover(Handover h);
	public Handover getDnameByHandover(Handover h);
	/**
	 * 查询交接单
	 * @param h
	 * @return
	 */
	public List<Handover> getHandoverInfo(Handover h);
	
	/**
	 * 补充查询:思路是在查询到有车辆信息和司机信息的基础上补加查询没有这些信息的交接单
	 * bug:分页时，第二页以后数据便会错乱
	 * @param h
	 * @return
	 */
	public List<Handover> getMoreHandoverInfo(Handover h);
	
	/**
	 * 添加交接单
	 * @param h
	 */
	public void addHandover(Handover h);
	
	/**
	 * 更新交接单
	 * @param h
	 */
	public void updateHandoverInfo(Handover h);
	
	
	/**
	 * 删除交接单
	 * @param list
	 */
	public void delmanyHandover(List list);
	
	/*根据id来查*/
	public Handover gethandover(Handover h);
}
