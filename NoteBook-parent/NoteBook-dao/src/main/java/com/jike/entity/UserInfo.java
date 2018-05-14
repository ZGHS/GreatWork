package com.jike.entity;

import java.util.List;

public class UserInfo {
	private Integer id;
	private String name;
	private String account;
	private String password;
	private List<RecordInfo> recordInfos;

	public UserInfo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RecordInfo> getRecordInfos() {
		return recordInfos;
	}

	public void setRecordInfos(List<RecordInfo> recordInfos) {
		this.recordInfos = recordInfos;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password
				+ ", recordInfos=" + recordInfos + "]";
	}

}
