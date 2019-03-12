package com.baizhi.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import com.baizhi.util.Load;

@Controller
@RequestMapping("/Banner")
public class BannerController {
	@Autowired
	private BannerService bs;
	
	
	
	
	/**
	 * @category 修改轮播图
	 * @param banner
	 * @param up
	 * @param session
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("update.do")
	public void update(Banner banner,MultipartFile up,HttpSession session) throws IllegalStateException, IOException{
		String RealPathDir =session.getServletContext().getRealPath("/imgPath");
		String uploading = Load.uploading(up, RealPathDir);
		banner.setImg_path(uploading);
		bs.modify(banner);
	}
	
	
	
	
	
	
	/**
	 * @category 删除轮播图
	 * @param ss
	 */
	@RequestMapping("delete.do")
	public void delete(String[] ss){
		//只删除数据库路径 在路径下的文件不删除
		bs.remove(ss);
	}
	
	
	
	
	
	/**
	 * @category 添加轮播图
	 * @param banner
	 * @param up
	 * @param session
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("insert.do")
	public void insert(Banner banner,MultipartFile up,HttpSession session) throws IllegalStateException, IOException{
		String RealPathDir =session.getServletContext().getRealPath("/imgPath");
		String uploading = Load.uploading(up, RealPathDir);
		banner.setImg_path(uploading);
		//获取uuid
		String uuid = UUID.randomUUID().toString().replace("-", "");
		banner.setId(uuid);
		bs.add(banner);
	}
}
