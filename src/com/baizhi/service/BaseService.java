package com.baizhi.service;



public interface BaseService<T> {
	void modify(T t);
	void add(T t);
	void remove(String[] t);
}
