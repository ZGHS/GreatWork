package com.jike.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jike.entity.RecordInfo;
import com.jike.entity.UserInfo;
import com.jike.service.RecordInfoService;

@Controller
public class NewFunctionController {
	@Autowired
	private RecordInfoService recordInfoService;

	@RequestMapping(value = "sendNews", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String sendNews(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		// 跨域问题，需要加上
		response.setHeader("Access-Control-Allow-Origin", "*");
		Integer uId = ((UserInfo) (session.getAttribute("accountInfo"))).getuId();

		UserInfo userInfo = new UserInfo();
		userInfo.setuId(uId);
		List<RecordInfo> selectNewestOne = recordInfoService.selectNewestOne(userInfo);

		String keyContent = selectNewestOne.get(0).getrContent();

		return "{\"info\":\"" + keyContent + "\"}";
	}

	public RecordInfoService getRecordInfoService() {
		return recordInfoService;
	}

	public void setRecordInfoService(RecordInfoService recordInfoService) {
		this.recordInfoService = recordInfoService;
	}

}
