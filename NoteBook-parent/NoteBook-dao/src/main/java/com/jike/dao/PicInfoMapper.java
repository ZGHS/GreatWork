package com.jike.dao;

import com.jike.entity.PicInfo;

public interface PicInfoMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(PicInfo record);

    int insertSelective(PicInfo record);

    PicInfo selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(PicInfo record);

    int updateByPrimaryKey(PicInfo record);
}