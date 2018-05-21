package com.jike.service;

import java.util.List;

import com.jike.entity.RecordInfo;

public interface RecordInfoService {
	RecordInfo saveRecord(RecordInfo recordInfo);

	String deleteRecord(Integer id);

	String updateRecord(RecordInfo recordInfo);

	List<RecordInfo> getByUid(Integer uid);

	List<RecordInfo> getByUidAndLabel(Integer uid, Integer label);
}
