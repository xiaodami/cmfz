package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Meun;

public interface MeunDao extends BaseDao<Meun>{
	List<Meun> selectByParentId(@Param("pid") Integer pid);
	<T> List<T> selectObject(@Param("s") String s, @Param("resultType") Class<T> resultType);
}
