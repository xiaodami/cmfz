package com.baizhi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.baizhi.dao.MeunDao;
import com.baizhi.entity.Meun;
@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class MeunServiceImpl implements MeunService{
	@Autowired
	private MeunDao ms;

	@Override
	public List<Meun> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meun> selectByParentId(Integer pid) {
		// TODO Auto-generated method stub
		return ms.selectByParentId(pid);
	}

	@Override
	public <T>List<T> selectByObject(String s) throws ClassNotFoundException {
		String t="com.baizhi.entity."+s;
		@SuppressWarnings("unchecked")
		Class<T> forName = (Class<T>) Class.forName(t);
		List<T> ss = ms.selectObject(s, forName);
		return ss;
	}
}
