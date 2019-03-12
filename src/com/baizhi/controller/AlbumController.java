package com.baizhi.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import com.baizhi.service.MeunService;
import com.baizhi.util.Load;

@Controller
@RequestMapping("/Album")
public class AlbumController {
	@Autowired
	private AlbumService bs;
	@Autowired
	private MeunService ms;
	
	
	
	
	
	
	/**
	 * @category 进入吉祥妙音的查询所有（Album内包含集合）
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping("select.do")
	@ResponseBody
	public List<Album> select() throws ClassNotFoundException{
		List<Album> findAll = bs.findAll();
		return findAll;
	}
	
	
	
	
	/**
	 * @category 添加
	 * @param album
	 * @param up
	 * @param session
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("insert.do")
	public void insert(Album album,MultipartFile up,HttpSession session) throws IllegalStateException, IOException{
		String RealPathDir =session.getServletContext().getRealPath("/imgPath");
		String uploading = Load.uploading(up, RealPathDir);
		album.setCoverimg(uploading);
		String uuid = UUID.randomUUID().toString().replace("-", "");
		album.setId(uuid);
		album.setPublicTime(new Date());
		bs.add(album);
	}
	
	
	
	
	/**
	 * @category 单个下载
	 * @param session
	 * @param path
	 * @param res
	 * @param req
	 * @throws Exception
	 */
	@RequestMapping("/download.do")
	public void downLoad(HttpSession session,@RequestParam("path")String path,HttpServletResponse res,HttpServletRequest req) throws Exception{
		path = URLDecoder.decode(path, "UTF-8");
		String RealPathDir = session.getServletContext().getRealPath("imgPath/"+path);
		//下载资源的路径
		InputStream in = new FileInputStream(RealPathDir);
		//获得输出流
		OutputStream out = res.getOutputStream();
		//设置响应头，指定文件下载到客户端的文件名和打开方式
		//设置响应类型
		path.lastIndexOf(".");
		String ext = path.substring(path.lastIndexOf("."));
		res.setContentType(req.getSession().getServletContext().getMimeType(ext));
		res.setHeader("content-disposition","attachment;fileName="+URLEncoder.encode(path,"UTF-8"));
		IOUtils.copy(in, out);
	}
	
	
	
	
	
	
	/**
	 * @category 批量下载
	 * @param session
	 * @param selects
	 * @param res
	 * @param req
	 * @throws Exception
	 */
	@RequestMapping("/downloads.do")
	public void downLoads(HttpSession session,String[] selects,HttpServletResponse res,HttpServletRequest req) throws Exception{
		byte[] buffer = new byte[1024];
		//生成zip文件存放位置
		String zip =new Date().getTime()+".zip";
		String zip1 ="D:\\Program Files (x86)\\apache-tomcat-8.0.53\\webapps\\cmfz_lwl\\imgPath\\"+zip;
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip1));
		List<String> list=new ArrayList<String>();
		for (String string : selects) {
			if(!list.contains(string)){
				list.add(string);
			}
		}
		for (String path : list) {
			FileInputStream f = new FileInputStream("D:\\Program Files (x86)\\apache-tomcat-8.0.53\\webapps\\cmfz_lwl\\imgPath\\"+path);
			out.putNextEntry(new ZipEntry(path));
			int len;
			// 读入需要下载的文件的内容，打包到zip文件
			while ((len = f.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			out.closeEntry();
			f.close();
		}
		out.close();
		InputStream in = new FileInputStream(zip1);
		OutputStream out1 = res.getOutputStream();
		zip.lastIndexOf(".");
		String ext = zip.substring(zip.lastIndexOf("."));
		res.setHeader("content-disposition","attachment;filename="+zip);
		res.setContentType(req.getSession().getServletContext().getMimeType(ext));
		res.setHeader("content-disposition","attachment;fileName="+URLEncoder.encode(zip,"UTF-8"));
		IOUtils.copy(in, out1);
	} 
}
