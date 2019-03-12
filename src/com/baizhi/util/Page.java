package com.baizhi.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Page {
	/**
	 * @category EasyUI分页
	 * @param list
	 * @param page
	 * @param rows
	 * @return
	 */
	 //page是第几页，oneTotal是每页几条数据
	public static <T>Map<String,Object> page(List<T> list,Integer page, Integer rows){
		int size = list.size();//长度
		Map<String,Object> c = new HashMap<String,Object>();
		c.put("total", size);
		//每页起始下标
		int index=(page-1)*rows;
		if(index>=size)index=(size/rows)*rows;
		//结尾下标
		int end=index+rows;
		if(end>size)end=size;
		List<T> subList = list.subList(index, end);
		c.put("rows",subList);
		return c;
	}
	
}
