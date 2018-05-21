package com.jike.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jike.dao.PicInfoMapper;
import com.jike.entity.PicInfo;
import com.jike.service.PicInfoService;

@Service("picInfoService")
public class PicInfoServiceImpl implements PicInfoService {
	private static Logger logger = Logger.getLogger(PicInfoService.class);
	
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
