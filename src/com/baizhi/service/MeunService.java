package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Meun;




public interface MeunService{
	List<Meun> findAll();
	List<Meun> selectByParentId(Integer pid);
	<T> List<T> selectByObject(String s) throws ClassNotFoundException;
}
