package com.jike.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jike.entity.UserInfo;
import com.jike.service.UserInfoService;

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "register", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String registerAccount(UserInfo userInfo) {
		UserInfo register = userInfoService.register(userInfo);
		String jsonString = JSON.toJSONString(register);
		System.out.println("registerAccount run");
		return jsonString;
	}

	@RequestMapping(value = "modify", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String modifyUserInfo(UserInfo userInfo) {
		UserInfo modifyProfile = userInfoService.modifyProfile(userInfo);
		String jsonString = JSON.toJSONString(modifyProfile);
		System.out.println("modifyUserInfo run");
		return jsonString;
	}

	@RequestMapping(value = "login", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(UserInfo userInfo, HttpSession httpSession) {
		UserInfo login = userInfoService.login(userInfo);
		httpSession.setAttribute("accountInfo", login);
		String jsonString = JSON.toJSONString(login);
		System.out.println("login run");
		return jsonString;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

}
