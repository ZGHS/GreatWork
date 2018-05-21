package com.jike.web;

import static org.hamcrest.CoreMatchers.nullValue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String login(HttpServletRequest request,HttpServletResponse response) {
		//跨域问题，需要加上
		response.setHeader("Access-Control-Allow-Origin", "*");
		String uAccount = request.getParameter("uAccount");
		String uPassword = request.getParameter("uPassword");
		UserInfo userInfo=new UserInfo(uAccount,uPassword);
		
		UserInfo login = userInfoService.login(userInfo);
		if (login != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("accountInfo", login);
			return "{\"info\":\"success\",\"page\":\"loginSuccess.action\"}";
		} else
			return "{\"info\":\"failure\",\"page\":\"login.html\"}";
	}
	@RequestMapping(value = "loginSuccess", produces = "text/html;charset=UTF-8")
	public String loginSuccess() {
			return "index";
	}

	
	
	@RequestMapping(value = "regetsession", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String reGetSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfo getsession;
		getsession = (UserInfo) session.getAttribute("accountInfo");
		String jsonString = JSON.toJSONString(getsession);
		return jsonString;
	}

	@RequestMapping(value = "logout", produces = "text/html;charset=UTF-8")
	public String logOut(HttpServletRequest request) {
		if (request.getSession(false) != null // 如果没有对应的session，返回null，不会创建session
				&& request.getSession().getAttribute("accoun") != null) {
			request.getSession().invalidate();
		}
		return "login";
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
			return "false";
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

}
