package com.jike.service;

import java.util.List;

import com.jike.entity.RecordInfo;

public interface RecordInfoService {
	RecordInfo saveRecord(RecordInfo recordInfo);

	String deleteRecord(RecordInfo recordInfo);

	String updateRecord(RecordInfo recordInfo);

	List<RecordInfo> getByUid(RecordInfo recordInfo);

	List<RecordInfo> getByUidAndLabel(RecordInfo recordInfo);
}
