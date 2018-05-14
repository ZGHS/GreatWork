package com.jike.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.dao.RecordInfoDao;
import com.jike.entity.RecordInfo;
import com.jike.service.RecordInfoService;

@Service("recordInfoService")
public class RecordInfoServiceImpl implements RecordInfoService {
	@Autowired
	public RecordInfoDao recordInfoDao;

	@Override
	public RecordInfo saveRecord(RecordInfo recordInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecordInfo deleteRecord(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecordInfo updateRecord(RecordInfo recordInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordInfo> getByUid(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordInfo> getByUidAndLabel(Integer uid, Integer label) {
		// TODO Auto-generated method stub
		return null;
	}

	public RecordInfoDao getRecordInfoDao() {
		return recordInfoDao;
	}

	public void setRecordInfoDao(RecordInfoDao recordInfoDao) {
		this.recordInfoDao = recordInfoDao;
	}

}
