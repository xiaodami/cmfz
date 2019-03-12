package com.baizhi.entity;

import java.util.Date;
import java.util.List;
/**
 * 
 * @author 米
 * @category 专辑表
 */
public class Album {
    private String id;
    private String title;
    private double score;
    private String brodcast;
    private String author;
    private String brief;
    private Date publicTime;
    private String count;
    private String coverimg;
    private int status;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;
    private List<Chapter> children;
  /* `ID` varchar(40) NOT NULL,
  `TITLE` varchar(50) DEFAULT NULL,
  `SCORE` int(2) DEFAULT NULL,
  `BRODCAST` varchar(40) DEFAULT NULL,
  `AUTHOR` varchar(40) DEFAULT NULL,
  `BRIEF` varchar(2000) DEFAULT NULL,
  `PUBLICTIME` datetime DEFAULT NULL,
            `COUNT` int(3) DEFAULT NULL,
  `COVERIMG` varchar(100) DEFAULT NULL,
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getBrodcast() {
		return brodcast;
	}
	public void setBrodcast(String brodcast) {
		this.brodcast = brodcast;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public Date getPublicTime() {
		return publicTime;
	}
	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getCoverimg() {
		return coverimg;
	}
	public void setCoverimg(String coverimg) {
		this.coverimg = coverimg;
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
	public List<Chapter> getChildren() {
		return children;
	}
	public void setChildren(List<Chapter> chapter) {
		this.children = chapter;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", score=" + score
				+ ", brodcast=" + brodcast + ", author=" + author + ", brief="
				+ brief + ", publicTime=" + publicTime + ", count=" + count
				+ ", coverimg=" + coverimg + ", status=" + status + ", ext1="
				+ ext1 + ", ext2=" + ext2 + ", ext3=" + ext3 + ", ext4=" + ext4
				+ ", ext5=" + ext5 + ", children=" + children + "]";
	}
	public Album(String id, String title, double score, String brodcast,
			String author, String brief, Date publicTime, String count,
			String coverimg, int status, String ext1, String ext2, String ext3,
			String ext4, String ext5, List<Chapter> chapter, List<Chapter> children) {
		super();
		this.id = id;
		this.title = title;
		this.score = score;
		this.brodcast = brodcast;
		this.author = author;
		this.brief = brief;
		this.publicTime = publicTime;
		this.count = count;
		this.coverimg = coverimg;
		this.status = status;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.ext5 = ext5;
		this.children= children;
	}
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
