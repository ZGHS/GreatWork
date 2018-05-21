package com.jike.dao;

import java.util.List;

import com.jike.entity.RecordInfo;

public interface RecordInfoMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(RecordInfo record);

    RecordInfo insertSelective(RecordInfo record);

    RecordInfo selectByPrimaryKey(Integer rId);
    
    List<RecordInfo> selectByUser(Integer uId);

    int updateByPrimaryKeySelective(RecordInfo record);

    int updateByPrimaryKeyWithBLOBs(RecordInfo record);

    int updateByPrimaryKey(RecordInfo record);
}