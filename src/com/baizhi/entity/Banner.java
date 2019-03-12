package com.baizhi.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author 米
 * @category 轮播图
 */
public class Banner {
    private String id; //`ID` varchar(40) NOT NULL,
    private String title;//`TITLE` varchar(40) DEFAULT NULL,
    private String img_path;//`IMG_PATH` varchar(100) DEFAULT NULL,
    private String description;// `DESCRIPTION` varchar(100) DEFAULT NULL,
    private int status;// `STATUS` int(2) DEFAULT NULL,
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
    private Date createTime; //`CREATETIME` datetime DEFAULT NULL,
    private String ext1;//           `EXT1` varchar(40) DEFAULT NULL,
    private String ext2;// `EXT2` varchar(40) DEFAULT NULL,
    private String ext3;// `EXT3` varchar(40) DEFAULT NULL,
    private String ext4;// `EXT4` varchar(40) DEFAULT NULL,
    private String ext5;// `EXT5` varchar(40) DEFAULT NULL,


    public Banner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Banner(String id, String title, String img_path, String description, int status, Date createTime, String ext1, String ext2, String ext3, String ext4, String ext5) {
        this.id = id;
        this.title = title;
        this.img_path = img_path;
        this.description = description;
        this.status = status;
        this.createTime = createTime;
        this.ext1 = ext1;
        this.ext2 = ext2;
        this.ext3 = ext3;
        this.ext4 = ext4;
        this.ext5 = ext5;
    }

    @Override
	public String toString() {
		return "Banner [id=" + id + ", title=" + title + ", img_path="
				+ img_path + ", description=" + description + ", status="
				+ status + ", createTime=" + createTime + ", ext1=" + ext1
				+ ", ext2=" + ext2 + ", ext3=" + ext3 + ", ext4=" + ext4
				+ ", ext5=" + ext5 + "]";
	}

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

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}
