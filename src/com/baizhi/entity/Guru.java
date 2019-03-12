package com.baizhi.entity;

import java.util.Date;

public class Guru {
	private String id;
	private String dharnaName;
	private String phono;
	private int status;
	private Date createTime;
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
	public String getDharnaName() {
		return dharnaName;
	}
	public void setDharnaName(String dharnaName) {
		this.dharnaName = dharnaName;
	}
	public String getPhono() {
		return phono;
	}
	public void setPhono(String phono) {
		this.phono = phono;
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
	@Override
	public String toString() {
		return "Guru [id=" + id + ", dharnaName=" + dharnaName + ", phono="
				+ phono + ", status=" + status + ", createTime=" + createTime
				+ ", ext1=" + ext1 + ", ext2=" + ext2 + ", ext3=" + ext3
				+ ", ext4=" + ext4 + ", ext5=" + ext5 + "]";
	}
	public Guru(String id, String dharnaName, String phono, int status,
			Date createTime, String ext1, String ext2, String ext3,
			String ext4, String ext5) {
		super();
		this.id = id;
		this.dharnaName = dharnaName;
		this.phono = phono;
		this.status = status;
		this.createTime = createTime;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.ext5 = ext5;
	}
	public Guru() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
