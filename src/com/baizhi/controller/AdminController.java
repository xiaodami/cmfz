package com.baizhi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.service.MeunService;
import com.baizhi.util.ImageUtil;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
	private AdminService bs;
	@Autowired
	private MeunService ms;
	
	
	
	
	/**
	 * @category 登录功能
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping("login.do")
	@ResponseBody
	public String select(String name,String password,HttpSession session) throws ClassNotFoundException{
		//获取所有管理员
		List<Object> selectByObject = ms.selectByObject("Admin");
		//判断账户和密码
		for (Object object : selectByObject) {
			Admin admin = (Admin) object;
			if(admin.getName().equals(name) && admin.getPassword().equals(password)){
				//存个session强制登录用
				session.setAttribute("admin", admin);
				//return 名字 显示用
				return admin.getId();
			}
		}
		return null;
	}
	
	
	
	
	/**
	 * @category 判断用户名是否可用
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping("pname.do")
	@ResponseBody
	public String selectName(String name,HttpSession session) throws ClassNotFoundException{
		//获取所有管理员
		List<Object> selectByObject = ms.selectByObject("Admin");
		//判断账户和密码
		for (Object object : selectByObject) {
			Admin admin = (Admin) object;
			if(admin.getName().equals(name)){
				return null;
			}
		}
		return "ok";
	}
	
	
	
	
	/**
	 * @category 判断验证码是否正确
	 * @param session
	 * @return
	 */
	@RequestMapping("judge.do")
	@ResponseBody
	public String judge(String captcha,HttpSession session){
		String code = (String) session.getAttribute("code");
		if(captcha.endsWith(code))return "ok";
		return null;
	}
	
	
	
	
	/**
	 * @category 验证码
	 * @param session
	 * @param response
	 */
	@RequestMapping("yan.do")
	public String yan(HttpSession session, HttpServletResponse response){
		String code = ImageUtil.getCode();//获取4位字符串
		session.setAttribute("code", code);//存作用域验证用
		BufferedImage image = ImageUtil.createImage(code);
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			ImageIO.write(image, "png", out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(out!=null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	
	
	
	
	/**
	 * @category 注册功能
	 * @param admin
	 */
	@RequestMapping("insert.do")
	public void insert(Admin admin,HttpSession session){
		//获取uuid设置id
		String uuid = UUID.randomUUID().toString().replace("-", "");
		admin.setId(uuid);
		session.setAttribute("admin", admin);
		bs.add(admin);
	}
	
	
	/**
	 * @category 注销
	 * @param session
	 * @param res
	 * @param req
	 * @throws IOException
	 */
	@RequestMapping("logout.do")
	public String logout(HttpSession session) throws IOException{
		session.invalidate();
		return "login";
	}
	
	
	
	
	/**
	 * @category 修改密码功能
	 * @param session
	 * @param password
	 */
	@RequestMapping("change.do")
	@ResponseBody
	public String change(HttpSession session,String password1,String password2){
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin.getPassword().equals(password1)){
			admin.setPassword(password2);
			bs.modify(admin);
			session.setAttribute("admin", admin);
			return "ok";
		}
		return null;
	}
}
