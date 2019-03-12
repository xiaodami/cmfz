package com.baizhi.dao;

import java.util.List;

public interface BaseDao<T> {
    void insert(T t);
   /* List<T> selectAll(T t);
    T query(String id);*/
    void update(T t);
    void delete(String[] t);
    List<T> queryAll();
}
