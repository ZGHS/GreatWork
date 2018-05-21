package com.jike.dao;

import com.jike.entity.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer uId);
    
    UserInfo selectByAccount(String Account);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}