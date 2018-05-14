package com.jike.entity;

public class PicInfo {
	private Integer id;
	private Integer rid;
	private String suffix;

	public PicInfo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString() {
		return "PicInfo [id=" + id + ", rid=" + rid + ", suffix=" + suffix + "]";
	}

}
