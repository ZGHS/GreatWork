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
public class RecordInfoController {
	@Autowired
	private RecordInfoService recordInfoService;

	@RequestMapping(value = "saveRecord", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String saveRecord(HttpServletRequest request,HttpSession session, HttpServletResponse response) {
		// 跨域问题，需要加上
		response.setHeader("Access-Control-Allow-Origin", "*");
		String rId = request.getParameter("rId");
		String rContent = request.getParameter("rContent");
		String rLabel = request.getParameter("rLabel");
		String rDelete = request.getParameter("rDelete");

		UserInfo loginUser = (UserInfo) session.getAttribute("accountInfo");
		if (loginUser==null) {
			return "{\"info\":\"failure\",\"page\":\"login.html\"}";
		}
		RecordInfo recordInfo ;
		if (rId!=null) {
			recordInfo = new RecordInfo(Integer.parseInt(rId), loginUser.getuId(), Integer.parseInt(rDelete),
					Integer.parseInt(rLabel), rContent);
		}else {
			 recordInfo = new RecordInfo(loginUser.getuId(), Integer.parseInt(rDelete),
					Integer.parseInt(rLabel), rContent);
		}
		
		RecordInfo saveRecord = recordInfoService.saveRecord(recordInfo);
		if (saveRecord != null) {
			loginUser.setuRecordInfos(recordInfoService.getByUid(loginUser.getuId()));
			session.setAttribute("accountInfo", loginUser);
			return "{\"info\":\"success\",\"page\":\"index.action\"}";
		} else
			return "{\"info\":\"failure\",\"page\":\"login.html\"}";
	}

	@RequestMapping(value = "deleteRecord", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteRecord(HttpServletRequest request,HttpSession session, HttpServletResponse response) {
		// 跨域问题，需要加上
		response.setHeader("Access-Control-Allow-Origin", "*");
		String rId = request.getParameter("rId");

		UserInfo loginUser = (UserInfo) session.getAttribute("accountInfo");
		if (loginUser==null) {
			return "{\"info\":\"failure\",\"page\":\"login.html\"}";
		}
		if (rId!=null) {
			recordInfoService.deleteRecord(Integer.parseInt(rId));
		}
			loginUser.setuRecordInfos(recordInfoService.getByUid(loginUser.getuId()));
			session.setAttribute("accountInfo", loginUser);
			return "{\"info\":\"success\",\"page\":\"index.action\"}";
	}
	
	
	
	
	

	@RequestMapping(value = "updateRecord", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateRecord(RecordInfo record) {
		System.out.println("hello world");
		System.out.println(record);
		String updateRecord = recordInfoService.updateRecord(record);
		// String jsonString = JSON.toJSONString(updateRecord);
		return updateRecord;
	}
	
	@RequestMapping(value = "getByUidAndMark", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getByUidAndMark(RecordInfo record) {
		System.out.println("hello world");
		System.out.println(record);
		List<RecordInfo> records = recordInfoService.getByUidAndLabel(record.getuId(), record.getrLabel());
		String jsonString = JSON.toJSONString(records);
		return jsonString;
	}

	@RequestMapping(value = "getByUid", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getByUid(Integer uid) {
		System.out.println("hello world");
		List<RecordInfo> records = recordInfoService.getByUid(uid);
		String jsonString = JSON.toJSONString(records);
		return jsonString;
	}

	@RequestMapping(value = "androidSaveRecord", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String saveRecordAndroid(RecordInfo recordInfo) {
		RecordInfo saveRecord = recordInfoService.saveRecord(recordInfo);
		String jsonString = JSON.toJSONString(saveRecord);
		return jsonString;
	}

	@RequestMapping(value = "androiddeleteRecord", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String androiddeleteRecord(RecordInfo recordInfo) {
		System.out.println("hello world");
		String deleteRecord = recordInfoService.deleteRecord(recordInfo);
		String jsonString = JSON.toJSONString(deleteRecord);
		return jsonString;
	}

	public RecordInfoService getRecordInfoService() {
		return recordInfoService;
	}

	public void setRecordInfoService(RecordInfoService recordInfoService) {
		this.recordInfoService = recordInfoService;
	}

}
