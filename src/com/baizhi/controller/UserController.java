package com.baizhi.controller;

import io.goeasy.GoEasy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.service.MeunService;
import com.baizhi.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private AdminService bs;
	@Autowired
	private MeunService ms;
	@Autowired
	private UserService us;
	
	
	
	/**
	 * @category a
	 * @return
	 * @throws ClassNotFoundException
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("a.do")
	@ResponseBody
	public Map<String,Object> select() throws ClassNotFoundException, JsonProcessingException{
		//GoEasy goEasy = new GoEasy("http(s)://rest-hangzhou.goeasy.io", "BC-8a3923492e974293a832321d4afe1ff8");
		System.out.println(ms);
		List<Object> selectByObject = ms.selectByObject("User");
		@SuppressWarnings("unused")
		int n = 0;
		Integer integer=0;
		List<Integer> listx = new ArrayList<Integer>();
		List<Integer> listy = new ArrayList<Integer>();
		for(int i=1;i<13;i++){
			listx.add(0);
			listy.add(0);
		}
		System.out.println(listx);
		SimpleDateFormat sdf=new SimpleDateFormat("MM");
		for (Object object : selectByObject) {
			User u=(User) object;
			String sex = u.getSex();
			String format = sdf.format(u.getCreatetime());
			if(sex.equals("0")){
				switch(format){
					case "01":integer = listx.get(0); integer++;listx.set(0, integer);
					case "02":integer = listx.get(1); integer++;listx.set(1, integer);
					case "03":integer = listx.get(2); integer++;listx.set(2, integer);
					case "04":integer = listx.get(3); integer++;listx.set(3, integer);
					case "05":integer = listx.get(4); integer++;listx.set(4, integer);
					case "06":integer = listx.get(5); integer++;listx.set(5, integer);
					case "07":integer = listx.get(6); integer++;listx.set(6, integer);
					case "08":integer = listx.get(7); integer++;listx.set(7, integer);
					case "09":integer = listx.get(8); integer++;listx.set(8, integer);
					case "10":integer = listx.get(9); integer++;listx.set(9, integer);
					case "11":integer = listx.get(10); integer++;listx.set(10, integer);
					case "12":integer = listx.get(11); integer++;listx.set(11, integer);
				}
			}else{
				switch(format){
					case "01":integer = listy.get(0); integer++;listy.set(0, integer);
					case "02":integer = listy.get(1); integer++;listy.set(1, integer);
					case "03":integer = listy.get(2); integer++;listy.set(2, integer);
					case "04":integer = listy.get(3); integer++;listy.set(3, integer);
					case "05":integer = listy.get(4); integer++;listy.set(4, integer);
					case "06":integer = listy.get(5); integer++;listy.set(5, integer);
					case "07":integer = listy.get(6); integer++;listy.set(6, integer);
					case "08":integer = listy.get(7); integer++;listy.set(7, integer);
					case "09":integer = listy.get(8); integer++;listy.set(8, integer);
					case "10":integer = listy.get(9); integer++;listy.set(9, integer);
					case "11":integer = listy.get(10); integer++;listy.set(10, integer);
					case "12":integer = listy.get(11); integer++;listy.set(11, integer);
				}
			}
		}
		System.out.println(listx);
		System.out.println(listy);
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("男", listx);
		map.put("女", listy);
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(map);
//		System.out.println(json);
		//goEasy.publish("channel", json);
		return map;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("b.do")
	@ResponseBody
	public List<Map<String,Object>> selectb() throws ClassNotFoundException{
		List<Object> selectByObject = ms.selectByObject("User");
		//Map<String,Object> map=new LinkedHashMap<String,Object>();
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("name","河北");
		map.put("value", 0);
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list.add(map);
		outer:for (Object object : selectByObject) {
				User u=(User) object;
				String privonce = u.getPrivonce();
				inner:for (Map<String, Object> map2 : list) {
						Object object2 = map2.get("name");
						if(object2.equals(privonce)){
							Object object3 = map2.get("value");
							Integer o4=(Integer) object3;
							o4++;
							map2.put("value", o4);
							break inner;
						}else if(map2.equals(list.get(list.size()-1)) && !object2.equals(privonce)){
							Map<String,Object> map1=new LinkedHashMap<String,Object>();
							map1.put("name",privonce);
							map1.put("value", 1);
							list.add(map1);
							break inner;
						}
				}
		}
		return list;
	}
	
	
	/**
	 * @category 导出下载
	 * @param session
	 * @param path
	 * @param res
	 * @param req
	 * @throws Exception
	 */
	@RequestMapping("/download.do")
	public void downLoad(HttpSession session,HttpServletResponse res,HttpServletRequest req) throws Exception{
		List<Object> list = ms.selectByObject("User");
		List<User> list1=new ArrayList<User>();
		for (Object object : list) {
			User user =(User)object;
			list1.add(user);
			System.out.println("这是得到的"+user);
		}
		
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息","用户"),User.class,list1);
		long times = new Date().getTime();
		String time=times+"";
		System.out.println("路径");
		workbook.write(new FileOutputStream("D:/Program Files (x86)/apache-tomcat-8.0.53/webapps/cmfz_lwl/docs/"+time+".xls"));
		workbook.close();
		time = URLDecoder.decode(time, "UTF-8");
		//String RealPathDir = session.getServletContext().getRealPath("imgs/"+path);
		//下载资源的路径
		InputStream in = new FileInputStream("D:/Program Files (x86)/apache-tomcat-8.0.53/webapps/cmfz_lwl/docs/"+time+".xls");
		//获得输出流
		OutputStream out = res.getOutputStream();
		//设置响应头，指定文件下载到客户端的文件名和打开方式
		//设置响应类型
		time=time+".xls";
		time.lastIndexOf(".");
		String ext = time.substring(time.lastIndexOf("."));
		res.setContentType(req.getSession().getServletContext().getMimeType(ext));
		res.setHeader("content-disposition","attachment;fileName="+URLEncoder.encode(time,"UTF-8"));
		IOUtils.copy(in, out);
	}
	
	
	
	
	
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws JsonProcessingException
	 * @throws ClassNotFoundException
	 */
	@RequestMapping("insert.do")
	public Map<String,Object> insert(User user) throws JsonProcessingException, ClassNotFoundException{
		user.setCreatetime(new Date());
		String uuid = UUID.randomUUID().toString().replace("-", "");
		user.setId(uuid);
		us.add(user);
		GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-8a3923492e974293a832321d4afe1ff8");
		System.out.println(ms);
		List<Object> selectByObject = ms.selectByObject("User");
		@SuppressWarnings("unused")
		int n = 0;
		Integer integer=0;
		List<Integer> listx = new ArrayList<Integer>();
		List<Integer> listy = new ArrayList<Integer>();
		for(int i=1;i<13;i++){
			listx.add(0);
			listy.add(0);
		}
		System.out.println(listx);
		SimpleDateFormat sdf=new SimpleDateFormat("MM");
		for (Object object : selectByObject) {
			User u=(User) object;
			String sex = u.getSex();
			String format = sdf.format(u.getCreatetime());
			if(sex.equals("0")){
				switch(format){
					case "01":integer = listx.get(0); integer++;listx.set(0, integer);
					case "02":integer = listx.get(1); integer++;listx.set(1, integer);
					case "03":integer = listx.get(2); integer++;listx.set(2, integer);
					case "04":integer = listx.get(3); integer++;listx.set(3, integer);
					case "05":integer = listx.get(4); integer++;listx.set(4, integer);
					case "06":integer = listx.get(5); integer++;listx.set(5, integer);
					case "07":integer = listx.get(6); integer++;listx.set(6, integer);
					case "08":integer = listx.get(7); integer++;listx.set(7, integer);
					case "09":integer = listx.get(8); integer++;listx.set(8, integer);
					case "10":integer = listx.get(9); integer++;listx.set(9, integer);
					case "11":integer = listx.get(10); integer++;listx.set(10, integer);
					case "12":integer = listx.get(11); integer++;listx.set(11, integer);
				}
			}else{
				switch(format){
					case "01":integer = listy.get(0); integer++;listy.set(0, integer);
					case "02":integer = listy.get(1); integer++;listy.set(1, integer);
					case "03":integer = listy.get(2); integer++;listy.set(2, integer);
					case "04":integer = listy.get(3); integer++;listy.set(3, integer);
					case "05":integer = listy.get(4); integer++;listy.set(4, integer);
					case "06":integer = listy.get(5); integer++;listy.set(5, integer);
					case "07":integer = listy.get(6); integer++;listy.set(6, integer);
					case "08":integer = listy.get(7); integer++;listy.set(7, integer);
					case "09":integer = listy.get(8); integer++;listy.set(8, integer);
					case "10":integer = listy.get(9); integer++;listy.set(9, integer);
					case "11":integer = listy.get(10); integer++;listy.set(10, integer);
					case "12":integer = listy.get(11); integer++;listy.set(11, integer);
				}
			}
		}
		System.out.println(listx);
		System.out.println(listy);
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("男", listx);
		map.put("女", listy);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		System.out.println(json);
		goEasy.publish("channel", json);
		return null;
	}
	
}
