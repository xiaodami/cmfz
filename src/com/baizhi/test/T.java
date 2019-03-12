package com.baizhi.test;

import io.goeasy.GoEasy;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

import com.baizhi.dao.MeunDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Article;
import com.baizhi.entity.Banner;
import com.baizhi.entity.User;
import com.baizhi.service.AlbumService;
import com.baizhi.service.MeunService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")
public class T {
	private static final Class<Object> Banner = null;
	@Autowired
	private MeunDao md;
	@Autowired
	private MeunService ms;
	@Autowired
	private AlbumService as;
	@Test
	public void testQuery() throws ClassNotFoundException{
		System.out.println(2&1);
	}
	@Test
	public void firstPage() throws ClassNotFoundException{
		//String uid,String type,String sub_type
		String uid="1";
		String type="all";
		String sub_type="xmfy";
		Map<String,Object> map=new HashMap<String,Object>();
		List<Banner> banner = ms.selectByObject("Banner");
		List<Album> album = ms.selectByObject("Album");
		List<Article> article = ms.selectByObject("Article");
		List<Article> a=new ArrayList<Article>();
		List<User> user = ms.selectByObject("User");
		switch(type){
			case "all":map.put("header", banner);map.put("album",album);map.put("article",article);break;
			case "wen":map.put("album", album);break;
			case "si":
				if(sub_type.equals("ssyj")){
					//article=new ArrayList<Article>();
					for (User user1 : user) {
						if(user1.getId().equals(uid)){
							String ext1 = user1.getExt1();//这个用户的上师ID
							for (Article art : article) {
								if(art.getAuthor().equals(ext1))a.add(art);
							}
						}
					}
					map.put("article", a);
				}else{
					map.put("article",article);
				}
				break;
		}
		System.out.println(map);
		//return map;
		@Test
	}
	public void test2() throws Exception{
		 File savefile = new File("D:/Program Files (x86)/apache-tomcat-8.0.53/webapps/cmfz_lwl/");
	        if (!savefile.exists()) {
	            savefile.mkdirs();
	        }3
		List<Object> list = ms.selectByObject("User");
		List<User> list1=new ArrayList<User>();
		for (Object object : list) {
			User user =(User)object;
			list1.add(user);
			System.out.println("这是得到的"+user);
		}
		System.out.println(list1);
		Workbook workbook2 = ExcelExportUtil.exportExcel(new ExportParams("全部用户信息","用户"),
	            User.class, list);
		workbook2.write(new FileOutputStream("E:/第一个excel文档.xls"));
		workbook2.close();
		
		/*Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
	            User.class, list1);
	workbook.write(new FileOutputStream("e:/testPoi/test2.xls"));
	workbook.close();
*/
		/*Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息","用户"),User.class,list1);
		long times = new Date().getTime();
		String time=times+"";
		System.out.println("路径");
		workbook.write(new FileOutputStream("D:/Program Files (x86)/apache-tomcat-8.0.53/webapps/cmfz_lwl/docs/"+time+".xls"));
		workbook.close();*/
		//HashMap<K, V>
	}
	@Test
	public void test3() throws ClassNotFoundException, JsonProcessingException{
		GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-8a3923492e974293a832321d4afe1ff8");
		System.out.println(ms);
		List<Object> selectByObject = ms.selectByObject("User");
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
		
		goEasy.publish("channel",json);
	}
	@Test
	public void test11(){
		System.out.println(10&2);
	}
}