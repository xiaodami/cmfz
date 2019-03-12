package com.baizhi.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @category 文章表
 * @author 米
 *
 */
public class Article {
	private String id;//`ID` varchar(40) NOT NULL,
	private String title;//  `TITLE` varchar(50) DEFAULT NULL,
	private String insert_img;//  `INSERT_IMG` varchar(100) DEFAULT NULL,
	private String content;//  `CONTENT` varchar(2000) DEFAULT NULL,
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	private Date publicTime;//  `PUBLICTIME` datetime DEFAULT NULL,
	private String author;//  `AUTHOR` varchar(40) DEFAULT NULL
	private String ext1;
	private String ext2;
	private String ext3;
	private String ext4;
	private String ext5;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInsert_img() {
		return insert_img;
	}
	public void setInsert_img(String insert_img) {
		this.insert_img = insert_img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublicTime() {
		return publicTime;
	}
	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	public String getExt3() {
		return ext3;
	}
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}
	public String getExt4() {
		return ext4;
	}
	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}
	public String getExt5() {
		return ext5;
	}
	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}
	
	
}
