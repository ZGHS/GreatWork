package com.jike.entity;

import java.util.List;

public class UserInfo {
    private Integer uId;

    private String uName;

    private String uAccount;

    private String uPassword;
    
    private List<RecordInfo> uRecordInfos;

    public UserInfo(String uAccount, String uPassword) {
    	this.uAccount=uAccount;
    	this.uPassword=uPassword;
	}

	public UserInfo(Integer uId, String uName, String uAccount, String uPassword) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uAccount = uAccount;
		this.uPassword = uPassword;
	}

	public UserInfo() {
	}

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

	@Override
	public String toString() {
		return "UserInfo [uId=" + uId + ", uName=" + uName + ", uAccount=" + uAccount + ", uPassword=" + uPassword
				+ ", uRecordInfos=" + uRecordInfos + "]";
	}
    
}