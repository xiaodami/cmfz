package com.baizhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao ad;
	@Override
	
	public void modify(Admin t) {
		// TODO Auto-generated method stub
		ad.update(t);
	}

	@Override
	public void add(Admin t) {
		// TODO Auto-generated method stub
		ad.insert(t);
	}
	
	@Override
	public void remove(String[] t) {
		// TODO Auto-generated method stub

	}

}
