package com.jike.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	@RequestMapping(value = "registerAndroid", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String registerAccountAndroid(UserInfo userInfo) {
		UserInfo register = userInfoService.register(userInfo);
		String jsonString = JSON.toJSONString(register);
		System.out.println("registerAccount run");
		return jsonString;
	}
	@RequestMapping(value = "register", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String registerAccount(UserInfo userInfo) {
		UserInfo register = userInfoService.register(userInfo);
		String jsonString = JSON.toJSONString(register);
		System.out.println("registerAccount run");
		return jsonString;
	}

	@RequestMapping(value = "modifyAndroid", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String modifyUserInfoAndroid(UserInfo userInfo) {
		UserInfo modifyProfile = userInfoService.modifyProfile(userInfo);
		String jsonString = JSON.toJSONString(modifyProfile);
		System.out.println("modifyUserInfo run");
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
	public String login(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		//跨域问题，需要加上
		response.setHeader("Access-Control-Allow-Origin", "*");
		String uAccount = request.getParameter("uAccount");
		String uPassword = request.getParameter("uPassword");
		UserInfo userInfo=new UserInfo(uAccount,uPassword);
		
		UserInfo login = userInfoService.login(userInfo);
		if (login != null) {
			session.setAttribute("accountInfo", login);
			return "{\"page\":\"index.action\"}";
		} else
			return "{\"page\":\"login.html\"}";
	}
	
	
	@RequestMapping(value = "isLogin", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String isLogin(HttpSession session) {
		if (session.getAttribute("accountInfo")==null) {
			return "{\"info\":\"failure\",\"page\":\"login.html\"}";
		}else {
			return "{\"info\":\"success\",\"page\":\"index.action\"}";
		}
	}
	
	@RequestMapping(value = "index", produces = "text/html;charset=UTF-8")
	public String loginSuccess(HttpSession session) {
			return "index";
	}

	
	
	@RequestMapping(value = "regetsession", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String reGetSession(HttpSession session) {
		//HttpSession session = request.getSession();
		UserInfo getsession = (UserInfo) session.getAttribute("accountInfo");
		String jsonString = JSON.toJSONString(getsession);
		return jsonString;
	}


	@RequestMapping(value = "logout", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String logOut(HttpSession session) {
	
			session.invalidate();
			return "{\"page\":\"login.html\"}";
		
	}

	// for text
	// @RequestMapping(value = "tlogin", produces = "text/html;charset=UTF-8")
	// public String tlogin() {
	// return "index";
	// }

	@RequestMapping(value = "loginandroid", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String loginAndroid(UserInfo userInfo, HttpServletRequest request) {
		UserInfo login = userInfoService.login(userInfo);
		if (login != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("accountInfo", login);
			UserInfo getsession;
			getsession = (UserInfo) session.getAttribute("accountInfo");
			String jsonString = JSON.toJSONString(getsession);
			return jsonString;
		} else
			return "{\"info\":\"false\"}";
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

}
