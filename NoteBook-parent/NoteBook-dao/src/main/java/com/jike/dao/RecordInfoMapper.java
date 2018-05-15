package com.jike.dao;

import com.jike.entity.RecordInfo;

public interface RecordInfoMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(RecordInfo record);

    int insertSelective(RecordInfo record);

    RecordInfo selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(RecordInfo record);

    int updateByPrimaryKeyWithBLOBs(RecordInfo record);

    int updateByPrimaryKey(RecordInfo record);
}