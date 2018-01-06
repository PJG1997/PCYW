package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Handover;
import com.yc.biz.HandoverBiz;
import com.yc.dao.HandoverDao;
@Service
@Transactional(readOnly=false,isolation=Isolation.DEFAULT,rollbackForClassName={"java.lang.RuntimeException"},propagation=Propagation.REQUIRED)
public class HandoverBizImpl implements HandoverBiz {
	
	@Resource(name="handoverDaoImpl")
	private HandoverDao handoverDao;
	@Override
	public List<Handover> getHandoverInfo(Handover h) {
		return handoverDao.getHandoverInfo(h);
	}

	@Override
	public void addHandover(Handover h) {
		handoverDao.addHandover(h);
	}

	@Override
	public void updateHandoverInfo(Handover h) {
		// TODO Auto-generated method stub
		handoverDao.updateHandoverInfo(h);
	}

	@Override
	public void delmanyHandover(List list) {
		// TODO Auto-generated method stub
		handoverDao.delmanyHandover(list);
	}

}
