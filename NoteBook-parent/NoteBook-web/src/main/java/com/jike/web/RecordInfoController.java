package com.jike.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jike.entity.RecordInfo;
import com.jike.service.RecordInfoService;

@Controller
public class RecordInfoController {
	@Autowired
	private RecordInfoService recordInfoService;

	@RequestMapping(value = "saveRecord", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String saveRecord(RecordInfo recordInfo) {
		RecordInfo saveRecord = recordInfoService.saveRecord(recordInfo);
		String jsonString = JSON.toJSONString(saveRecord);
		return jsonString;
	}

	@RequestMapping(value = "deleteRecord", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteRecord(Integer id) {
		System.out.println("hello world");
		String deleteRecord = recordInfoService.deleteRecord(id);
		String jsonString = JSON.toJSONString(deleteRecord);
		return jsonString;
	}

	@RequestMapping(value = "updateRecord", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateRecord(RecordInfo record) {
		System.out.println("hello world");
		System.out.println(record);
		String updateRecord = recordInfoService.updateRecord(record);
//		String jsonString = JSON.toJSONString(updateRecord);
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

	public RecordInfoService getRecordInfoService() {
		return recordInfoService;
	}

	public void setRecordInfoService(RecordInfoService recordInfoService) {
		this.recordInfoService = recordInfoService;
	}

}
