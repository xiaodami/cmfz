package com.baizhi.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * @category 章节表
 * @author 米
 *
 */
public class Chapter {
	private String id;// `ID` varchar(40) NOT NULL,
	private String title;// `TITLE` varchar(40) DEFAULT NULL,
	private String url;// `URL` varchar(100) DEFAULT NULL,
	private double size;// `SIZE` double(10,2) DEFAULT NULL,
	private String duration;// `DURATION` varchar(40) DEFAULT NULL,
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	private Date createTime;// `CREATETIME` datetime DEFAULT NULL,
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	public Chapter(String id, String title, String url, double size,
			String duration, Date createTime, String ext1, String ext2,
			String ext3, String ext4, String ext5) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.size = size;
		this.duration = duration;
		this.createTime = createTime;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.ext5 = ext5;
	}
	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Chapter [id=" + id + ", title=" + title + ", url=" + url
				+ ", size=" + size + ", duration=" + duration + ", createTime="
				+ createTime + ", ext1=" + ext1 + ", ext2=" + ext2 + ", ext3="
				+ ext3 + ", ext4=" + ext4 + ", ext5=" + ext5 + "]";
	}
	
	
}
