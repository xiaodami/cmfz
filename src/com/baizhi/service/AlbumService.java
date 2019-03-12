package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Album;

public interface AlbumService extends BaseService<Album>{

	List<Album> findAll();
}
