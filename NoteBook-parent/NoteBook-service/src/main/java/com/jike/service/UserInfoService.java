package com.jike.service;

import com.jike.entity.UserInfo;

public interface UserInfoService {
	UserInfo login(UserInfo userInfo);

	UserInfo register(UserInfo userInfo);
	
	UserInfo modifyProfile(UserInfo userInfo);
}
