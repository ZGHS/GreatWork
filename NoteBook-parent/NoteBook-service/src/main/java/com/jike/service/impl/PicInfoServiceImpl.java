package com.jike.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jike.dao.PicInfoMapper;
import com.jike.entity.PicInfo;
import com.jike.service.PicInfoService;

@Service("picInfoService")
public class PicInfoServiceImpl implements PicInfoService {
	@Autowired
	public PicInfoMapper picInfoDao;

	@Override
	public PicInfo savePic(PicInfo picInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PicInfo deletePic(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PicInfo updatePic(PicInfo picInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PicInfo> getByRid(Integer rid) {
		// TODO Auto-generated method stub
		return null;
	}

	public PicInfoMapper getPicInfoDao() {
		return picInfoDao;
	}

	public void setPicInfoDao(PicInfoMapper picInfoDao) {
		this.picInfoDao = picInfoDao;
	}

}
