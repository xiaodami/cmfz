package com.baizhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao ud;
	@Override
	public void modify(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(User t) {
		// TODO Auto-generated method stub
		ud.insert(t);
	}

	@Override
	public void remove(String[] t) {
		// TODO Auto-generated method stub

	}

}
