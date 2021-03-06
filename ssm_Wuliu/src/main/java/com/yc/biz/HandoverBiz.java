package com.yc.biz;

import java.util.List;

import com.yc.bean.Handover;

public interface HandoverBiz {
	/*
	 * 根据车子的编号查车子的信息*/
	public List<Handover> getHandoverInfo(Handover h);
	/*
	 *补充查询 
	 */
	public List<Handover> getMoreHandoverInfo(Handover h);
	
	/*
	 * 分布式查询
	 */
	public List<Handover> getFirstHandoverInfo(Handover h);
	public Handover getCnumberByHandover(Handover h);
	public Handover getDnameByHandover(Handover h);
	/*
	 * 添加车子的信息*/
	public void addHandover(Handover h);
	
	/*
	 * 更新车子的信息*/
	public void updateHandoverInfo(Handover h);
	
	
	/*
	 * 根据车子id批量删除车辆*/
	public void delmanyHandover(List list);
	
	/*根据id来查*/
	public Handover gethandover(Handover h);
	
	/**
	 * 通过订单id查询
	 */
	public List<Handover> selectForOsid(Handover h);
	
	public Handover gethandoverByupdate(Handover h);
}
