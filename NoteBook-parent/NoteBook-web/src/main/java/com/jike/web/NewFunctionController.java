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
import com.jike.service.NewFunctionService;
import com.jike.service.RecordInfoService;
import com.jike.utils.AnalyseUtil;

@Controller
public class NewFunctionController {
	@Autowired
	private RecordInfoService recordInfoService;
	@Autowired
	private NewFunctionService newFunctionService;

	@RequestMapping(value = "sendNews", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String sendNews(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		// 跨域问题，需要加上
		response.setHeader("Access-Control-Allow-Origin", "*");
		// Integer uId = ((UserInfo) (session.getAttribute("accountInfo"))).getuId();
		String uId = request.getParameter("uId");
		// Integer uId =1;
		//
		// UserInfo userInfo = new UserInfo();
		// userInfo.setuId(Integer.parseInt(uId));
		List<RecordInfo> byUid = recordInfoService.getByUid(Integer.parseInt(uId));
		// List<RecordInfo> selectNewestOne =
		// recordInfoService.selectNewestOne(userInfo);
		//
		// String keyContent = selectNewestOne.get(0).getrContent();
		// String text = "北京是一家高科技公司";
		String text = null;
		if (byUid.size() > 0) {

			text = byUid.get(byUid.size() - 1).getrContent();
		}
		List<String> news = newFunctionService.getNews(text);
		if (news != null && news.size() > 0) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+news);
			return news.get(0);
		} else {
			return null;
		}
	}

	public RecordInfoService getRecordInfoService() {
		return recordInfoService;
	}

	public void setRecordInfoService(RecordInfoService recordInfoService) {
		this.recordInfoService = recordInfoService;
	}

}
