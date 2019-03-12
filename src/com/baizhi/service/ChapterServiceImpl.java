package com.baizhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ChapterServiceImpl implements ChapterService {
	@Autowired
	private ChapterDao cd;
	@Override
	public void modify(Chapter t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Chapter t) {
		// TODO Auto-generated method stub
		cd.insert(t);
	}

	@Override
	public void remove(String[] t) {
		// TODO Auto-generated method stub

	}

}
