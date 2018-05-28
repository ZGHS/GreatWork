package com.jike.service;

import java.util.List;

import com.jike.entity.RecordInfo;
import com.jike.entity.UserInfo;

public interface RecordInfoService {
	RecordInfo saveRecord(RecordInfo recordInfo);

	String deleteRecord(RecordInfo recordInfo);

	//String updateRecord(RecordInfo recordInfo);
	
	List<RecordInfo> getByUid(Integer uId);
	
	List<RecordInfo> getByUidAndLabel(RecordInfo recordInfo);
	
	List<RecordInfo> selectNewestOne(UserInfo userInfo);
}
