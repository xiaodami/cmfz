package com.baizhi.util;

import java.io.File;
import java.io.IOException;


import org.springframework.web.multipart.MultipartFile;

public class Load {
	/**
	 * @category 上传文件工具类
	 * @param up
	 * @param path
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * 
	 * 需要两个参数 up是上传过来的文件  path是需要存储的路径 
	 * 返回值是上传过来的文件名则是成功
	 * 返回值为null则证明没有传递过来up文件
	 */
	public static String uploading(MultipartFile up,String path) throws IllegalStateException, IOException{
		//获取名字
		String fileName = up.getOriginalFilename();
		//获取上传文件类型
		if(!fileName.equals("")){//判断有没有文件上传 如果有则执行
			//获取文件
			File file = new File(path+"\\"+fileName);
			//判断有没有这个文件 如果没有则执行
			if(!file.isFile()){
				//上传这个文件
				up.transferTo(new File(path+"\\"+fileName));
			}
			return fileName;
		}
		return null;
	}
	
	public static String download(){
		return null;
		
	}
}
