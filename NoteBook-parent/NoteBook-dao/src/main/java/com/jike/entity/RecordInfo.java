package com.jike.entity;

import java.util.Date;

public class RecordInfo {
    private Integer rId;

    private Integer uId;

    private Date rDate;

    private Integer rDelete;

    private Integer rLabel;

    private String rContent;

   

	public RecordInfo(Integer rId, Integer uId, Integer rDelete, Integer rLabel, String rContent) {
		super();
		this.rId = rId;
		this.uId = uId;
		this.rDelete = rDelete;
		this.rLabel = rLabel;
		this.rContent = rContent;
	}

	public RecordInfo() {
	}

	public RecordInfo(Integer uId, Integer rDelete, Integer rLabel, String rContent) {
		this.uId=uId;
		this.rDelete=rDelete;
		this.rLabel=rLabel;
		this.rContent=rContent;
		
	}

	public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public Integer getrDelete() {
        return rDelete;
    }

    public void setrDelete(Integer rDelete) {
        this.rDelete = rDelete;
    }

    public Integer getrLabel() {
        return rLabel;
    }

    public void setrLabel(Integer rLabel) {
        this.rLabel = rLabel;
    }

    public String getrContent() {
        return rContent;
    }

    public void setrContent(String rContent) {
        this.rContent = rContent;
    }
}