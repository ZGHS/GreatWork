package com.jike.entity;

import java.util.Date;
import java.util.List;

public class RecordInfo {
	private Integer id;
	private Integer uid;
	private String content;
	private Date date;
	private Integer isDelete;
	private Integer label;
	private List<PicInfo> picInfos;

	public RecordInfo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getLabel() {
		return label;
	}

	public void setLabel(Integer label) {
		this.label = label;
	}

	public List<PicInfo> getPicInfos() {
		return picInfos;
	}

	public void setPicInfos(List<PicInfo> picInfos) {
		this.picInfos = picInfos;
	}

	@Override
	public String toString() {
		return "RecordInfo [id=" + id + ", uid=" + uid + ", content=" + content + ", date=" + date + ", isDelete="
				+ isDelete + ", label=" + label + ", picInfos=" + picInfos + "]";
	}

}
