package com.baizhi.entity;

/**
 * 
 * @author 米
 * @category 管理员
 */
public class Admin {
   private String id;
   private String name;
   private String password;
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
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
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
	return "Admin [id=" + id + ", name=" + name + ", password=" + password
			+ ", ext1=" + ext1 + ", ext2=" + ext2 + ", ext3=" + ext3
			+ ", ext4=" + ext4 + ", ext5=" + ext5 + "]";
}
public Admin(String id, String name, String password, String ext1, String ext2,
		String ext3, String ext4, String ext5) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.ext1 = ext1;
	this.ext2 = ext2;
	this.ext3 = ext3;
	this.ext4 = ext4;
	this.ext5 = ext5;
}
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
   
}
