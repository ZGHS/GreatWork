package com.jike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jike.dao.RecordInfoMapper;
import com.jike.dao.UserInfoMapper;
import com.jike.entity.UserInfo;
import com.jike.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	public UserInfoMapper userInfoDao;
	@Autowired
	public RecordInfoMapper recordInfoDao;

	@Override
	public UserInfo login(UserInfo userInfo) {
		UserInfo realUserInfo = userInfoDao.selectByAccount(userInfo.getuAccount());
		if (realUserInfo == null) {
			return null;
		} else if (userInfo.getuPassword().equals(realUserInfo.getuPassword())) {
			realUserInfo.setuRecordInfos(recordInfoDao.selectByUser(realUserInfo.getuId()));

			return realUserInfo;
		}
		return null;
	}

	@Override
	public UserInfo register(UserInfo userInfo) {
		if (userInfoDao.selectByAccount(userInfo.getuAccount()) == null) {
			userInfoDao.insert(userInfo);
			return userInfoDao.selectByAccount(userInfo.getuAccount());
		}
		return null;
	}

	@Override
	public UserInfo modifyProfile(UserInfo userInfo) {
		userInfoDao.updateByPrimaryKeySelective(userInfo);
		return userInfoDao.selectByPrimaryKey(userInfo.getuId());
	}

	public UserInfoMapper getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoMapper userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

}
