package com.baizhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class BannerServiceImpl implements BannerService {
	@Autowired
	private BannerDao bd;
	@Override
	public void modify(Banner ba) {
		// TODO Auto-generated method stub
		System.out.println("serviceceng"+ba);
		bd.update(ba);
	}
	@Override
	public void add(Banner t) {
		// TODO Auto-generated method stub
		bd.insert(t);
	}
	@Override
	public void remove(String[] arr) {
		// TODO Auto-generated method stub
		//bd.delete(t);
		bd.delete(arr);
	}


}
