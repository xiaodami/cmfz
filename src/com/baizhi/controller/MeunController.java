package com.baizhi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.Meun;
import com.baizhi.service.MeunService;
import com.baizhi.util.Page;

@Controller
@RequestMapping("/meun")
public class MeunController {
	@Autowired
	private MeunService ms;
	
	
	
	/**
	 * @category 根据父类id查询菜单
	 * @param pid
	 * @return
	 */
	@RequestMapping("selectByParentId.do")
	@ResponseBody
	public List<Meun> selectByParentId(Integer pid){
		System.out.println(pid);
		List<Meun> findAll = ms.selectByParentId(pid);
		return findAll;
	}
	
	
	
	/**
	 * @category 根据父类id查询表
	 * @param t
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping("selectClazz.do")
	@ResponseBody
	public List<Object> selectAllClazz(String t) throws ClassNotFoundException{
		System.out.println("这里是查类"+t);
		List<Object> selectByObject = ms.selectByObject(t);
		return selectByObject;
	}
	
	
	
	
	
	
	
	
	/**
	 * @category jsp返回一个对象 根据对象查询所有表
	 * @param t
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@RequestMapping("selectAllObject.do")
	@ResponseBody
	public Map<String,Object> selectAllObject(String t,Integer page,Integer rows) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		System.out.println("这里查询所有");
		List<Object> selectByObject = ms.selectByObject(t);
		System.out.println(selectByObject);
		Map<String, Object> page2 = Page.page(selectByObject,page,rows);
		System.out.println(page2);
		return page2;
	}
	
}
