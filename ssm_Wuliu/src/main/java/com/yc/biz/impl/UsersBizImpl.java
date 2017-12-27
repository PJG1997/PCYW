package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Users;
import com.yc.biz.UsersBiz;
import com.yc.dao.UsersDao;


@Service
@Transactional(readOnly=true)
public class UsersBizImpl implements UsersBiz{
	@Resource(name="usersDaoImpl")
	private UsersDao usersDao;
	@Override
	public Users login(Users user) {
		return usersDao.login(user);
	}

}
