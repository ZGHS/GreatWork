package com.jike.service;

import java.util.List;

import com.jike.entity.PicInfo;

public interface PicInfoService {
	PicInfo savePic(PicInfo picInfo);

	PicInfo deletePic(Integer id);

	PicInfo updatePic(PicInfo picInfo);

	List<PicInfo> getByRid(Integer rid);

}
