package com.baizhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class AlbumServiceImpl implements AlbumService {
	@Autowired
	private AlbumDao ad;

	@Override
	public void modify(Album t) {
		// TODO Auto-generated method stub
		ad.update(t);
	}

	@Override
	public void add(Album t) {
		// TODO Auto-generated method stub
		ad.insert(t);
	}

	@Override
	public void remove(String[] t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Album> findAll() {
		// TODO Auto-generated method stub
		List<Album> queryAll = ad.queryAll();
		for (Album album : queryAll) {
			album.setCount(album.getChildren().size()+"");
		}
		return ad.queryAll();
	}

	
	

}
