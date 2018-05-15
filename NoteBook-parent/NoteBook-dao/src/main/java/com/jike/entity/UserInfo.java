package com.jike.entity;

import java.util.List;

public class UserInfo {
    private Integer uId;

    private String uName;

    private String uAccount;

    private String uPassword;
    
    private List<RecordInfo> uRecordInfos;

    public List<RecordInfo> getuRecordInfos() {
		return uRecordInfos;
	}

	public void setuRecordInfos(List<RecordInfo> uRecordInfos) {
		this.uRecordInfos = uRecordInfos;
	}

	public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
}