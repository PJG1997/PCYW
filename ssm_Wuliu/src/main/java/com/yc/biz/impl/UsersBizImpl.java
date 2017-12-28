package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Override
	public Map<String, Object> searchAllUsers() {
		
		List<Users> ls = usersDao.searchAllUsers();
		Map<String,Object> maps = new HashMap<String,Object>();
		int result = usersDao.total();
		maps.put("total", result);
		maps.put("rows", ls);
		return maps;
	}

}
