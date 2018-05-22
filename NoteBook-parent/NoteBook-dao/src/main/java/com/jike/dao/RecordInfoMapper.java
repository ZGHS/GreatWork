package com.jike.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jike.entity.RecordInfo;
import com.jike.entity.UserInfo;

public interface RecordInfoMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(RecordInfo record);

    int insertSelective(RecordInfo record);

    RecordInfo selectByPrimaryKey(Integer rId);
    
    List<RecordInfo> selectByUser(Integer uId);

    int updateByPrimaryKeySelective(RecordInfo record);

    int updateByPrimaryKeyWithBLOBs(RecordInfo record);

    int updateByPrimaryKey(RecordInfo record);

	RecordInfo selectNewInfo(RecordInfo recordInfo);

	int updated(Integer id);

	List<RecordInfo> selectByUserAndKey(@Param("uId")Integer uId, @Param("rLabel")Integer rLabel);
	
	List<RecordInfo> selectNewestOne(UserInfo userInfo);
	
}