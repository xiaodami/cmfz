package com.baizhi.entity;

import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import cn.afterturn.easypoi.excel.annotation.Excel;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	@Excel(name="用户编号")
    private String id;//`ID` varchar(40) NOT NULL,
	//@Excel(name = "用户头像", type = 2 ,width = 40 , imageType = 1)
	@Excel(imageType=1,name="用户头像")
    private String phono;//
	@Excel(name="用户法名")
    private String dhramaname;
	@Excel(name="用户名")
    private String realname;
	//@Excel(name="性别", replace = { "男_1", "女_2" }, suffix = "生", isImportField = "true_st")
    private String sex;
	@Excel(name="用户省份")
    private String privonce;
	@Excel(name="用户城市")
    private String city;
	@Excel(name="用户签名")
    private String sign;
	@Excel(name="用户电话")
    private String phonenum;
	@Excel(name="用户密码")
    private String password;
	@Excel(name="用户编号")
    private String salt;
	//@Excel(name="注册时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	@Excel(name="创建时间",databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd")
    private Date createtime;
	@Excel(name="用户状态")
    private int status;
	@Excel(name="备用1")
    private String ext1;
	@Excel(name="备用2")
    private String ext2;
	@Excel(name="备用3")
    private String ext3;
	@Excel(name="备用4")
    private String ext4;
	@Excel(name="备用5")
    private String ext5;
  /*`PHONO` varchar(100) DEFAULT NULL,
  `DHRAMANAME` varchar(40) DEFAULT NULL,
  `REALNAME` varchar(40) DEFAULT NULL,
  `SEX` int(1) DEFAULT NULL,
  `PRIVONCE` varchar(40) DEFAULT NULL,
  `CITY` varchar(40) DEFAULT NULL,
  `SIGN` varchar(100) DEFAULT NULL,
  `PHONENUM` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(20) DEFAULT NULL,
  `SALT` varchar(40) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
            `STATUS` int(1) DEFAULT NULL,
  `EXT1` varchar(40) DEFAULT NULL,
  `EXT2` varchar(40) DEFAULT NULL,
  `EXT3` varchar(40) DEFAULT NULL,
  `EXT4` varchar(40) DEFAULT NULL,
  `EXT5` varchar(40) DEFAULT NULL,*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhono() {
		return phono;
	}
	public void setPhono(String phono) {
		this.phono = phono;
	}
	public String getDhramaname() {
		return dhramaname;
	}
	public void setDhramaname(String dhramaname) {
		this.dhramaname = dhramaname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPrivonce() {
		return privonce;
	}
	public void setPrivonce(String privonce) {
		this.privonce = privonce;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", phono=" + phono + ", dhramaname="
				+ dhramaname + ", realname=" + realname + ", sex=" + sex
				+ ", privonce=" + privonce + ", city=" + city + ", sign="
				+ sign + ", phonenum=" + phonenum + ", password=" + password
				+ ", salt=" + salt + ", createtime=" + createtime + ", status="
				+ status + ", ext1=" + ext1 + ", ext2=" + ext2 + ", ext3="
				+ ext3 + ", ext4=" + ext4 + ", ext5=" + ext5 + "]";
	}
	public User(String id, String phono, String dhramaname, String realname,
			String sex, String privonce, String city, String sign,
			String phonenum, String password, String salt, Date createtime,
			int status, String ext1, String ext2, String ext3, String ext4,
			String ext5) {
		super();
		this.id = id;
		this.phono = phono;
		this.dhramaname = dhramaname;
		this.realname = realname;
		this.sex = sex;
		this.privonce = privonce;
		this.city = city;
		this.sign = sign;
		this.phonenum = phonenum;
		this.password = password;
		this.salt = salt;
		this.createtime = createtime;
		this.status = status;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.ext5 = ext5;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
