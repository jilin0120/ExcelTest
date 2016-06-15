package com.b510.excel.vo;

import java.sql.Timestamp;
import java.util.List;

public class CcChapter implements java.io.Serializable {

	// Fields

	private String chapterId;
	private String fatherId;
	private String chapterName;
	private String chapterNum;
	private Integer level;
	private String code;
	private Integer num;
	private Integer isUse;
	private Timestamp createTime;
	private List<CcChapter> chapterList;
	private Boolean hasRes;

	// Constructors

	/** default constructor */
	public CcChapter() {
	}

	/** minimal constructor */
	public CcChapter(String chapterId) {
		this.chapterId = chapterId;
	}


	public String getChapterId() {
		return this.chapterId;
	}

	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}

	public String getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String getChapterName() {
		return this.chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	
	public String getChapterNum() {
		return this.chapterNum;
	}

	public void setChapterNum(String chapterNum) {
		this.chapterNum = chapterNum;
	}
	
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getIsUse() {
		return this.isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Boolean getHasRes() {
		return hasRes;
	}

	public void setHasRes(Boolean hasRes) {
		this.hasRes = hasRes;
	}
	
	

}