package com.jike.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.jike.dao.PicInfoMapper;
import com.jike.dao.RecordInfoMapper;
import com.jike.entity.Result;
import com.jike.service.NewFunctionService;
import com.jike.utils.AnalyseUtil;
import com.jike.utils.CityNameUtil;
import com.jike.utils.NewsUtil;

@Service("newFunctionService")
public class NewFunctionServiceImpl implements NewFunctionService {
	@Autowired
	public RecordInfoMapper recordInfoDao;

	@Override
	public List<String> getNews(String text) {
		String result = AnalyseUtil.getAnalyseResult(text);
		Gson gson = new Gson();
		Result resultNews = gson.fromJson(result, Result.class);

		List<String> cityNames = CityNameUtil.getCityName(resultNews);
		List<String> news = NewsUtil.getNews(cityNames);
		return news;
	}

}
