package com.jike.service;

import java.util.List;

import com.jike.entity.RecordInfo;

public interface RecordInfoService {
	RecordInfo saveRecord(RecordInfo recordInfo);

	RecordInfo deleteRecord(Integer id);

	RecordInfo updateRecord(RecordInfo recordInfo);

	List<RecordInfo> getByUid(Integer uid);

	List<RecordInfo> getByUidAndLabel(Integer uid, Integer label);
}
