package com.jike.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.dao.RecordInfoMapper;
import com.jike.entity.RecordInfo;
import com.jike.service.RecordInfoService;

@Service("recordInfoService")
public class RecordInfoServiceImpl implements RecordInfoService {
	@Autowired
	public RecordInfoMapper recordInfoDao;

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
	public String updateRecord(RecordInfo recordInfo) {
		recordInfo.setrDate(new Date());
		if(recordInfo.getrId()==null)
		{
			recordInfoDao.insertSelective(recordInfo);
			return "success insert";
		}
		else {
			recordInfoDao.updateByPrimaryKeySelective(recordInfo);
			return "success save";
		}
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

	public RecordInfoMapper getRecordInfoDao() {
		return recordInfoDao;
	}

	public void setRecordInfoDao(RecordInfoMapper recordInfoDao) {
		this.recordInfoDao = recordInfoDao;
	}

}
