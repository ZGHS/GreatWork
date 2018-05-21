package com.jike.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		Calendar calendar = Calendar.getInstance();
		calendar.get(Calendar.YEAR);
		calendar.get(Calendar.MONTH);
		calendar.get(Calendar.DATE);
		calendar.get(Calendar.HOUR);
		calendar.get(Calendar.MINUTE);
		calendar.get(Calendar.SECOND);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(recordInfo.getrId()==null)
		{
			try {
				recordInfo.setrDate(simpleDateFormat.parse(simpleDateFormat.format(calendar.getTime())));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			recordInfoDao.insertSelective(recordInfo);
			recordInfo=recordInfoDao.selectNewInfo(recordInfo);
		}
		else {
			recordInfo.setrDate(new Date());
			recordInfoDao.updateByPrimaryKeySelective(recordInfo);
		}
		return recordInfo;
	}

	@Override
	public String deleteRecord(Integer id) {
		if(recordInfoDao.updated(id)==1)
			return "true";
		return "false";
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
