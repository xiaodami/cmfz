package com.baizhi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.Album;
import com.baizhi.entity.Article;
import com.baizhi.entity.Banner;
import com.baizhi.entity.User;
import com.baizhi.service.MeunService;



@Controller
@RequestMapping("/first_page")
public class FirstPageController {
	@Autowired
	private MeunService ms;
	
	
	
	/**
	 * 
	 * @param uid
	 * @param type
	 * @param sub_type
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping("first_page.do")
	@ResponseBody
	public Map<String,Object> firstPage(String uid,String type,String sub_type) throws ClassNotFoundException{
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
		return map;
	}
	
	
	
	
}
