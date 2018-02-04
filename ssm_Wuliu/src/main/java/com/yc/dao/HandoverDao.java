package com.yc.dao;

import java.util.List;

import com.yc.bean.Handover;

public interface HandoverDao {
	
	/**
	 * 查询交接单
	 * @param h
	 * @return
	 */
	public List<Handover> getHandoverInfo(Handover h);
	
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
