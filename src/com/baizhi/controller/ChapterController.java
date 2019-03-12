package com.baizhi.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.Load;

@Controller
@RequestMapping("/Chapter")
public class ChapterController {
	@Autowired
	private ChapterService cs;
	
	
	
	/**
	 * @category 添加音频
	 * @param c
	 * @param up
	 * @param session
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("insert.do")
	public void insert(Chapter c,MultipartFile up,HttpSession session) throws IllegalStateException, IOException{
		//获取绝对路径
		String realPathDir =session.getServletContext().getRealPath("/imgPath");
		//调用工具类上传
		String uploading = Load.uploading(up, realPathDir);
		//获取大小
		File file=new File(realPathDir);
		long length = file.length();
		//long size = up.getSize();
		c.setSize(length);
		c.setUrl(uploading);
		//获取UUID
		String uuid = UUID.randomUUID().toString().replace("-", "");
		c.setId(uuid);
		c.setCreateTime(new Date());
		cs.add(c);
	}
}
