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
		System.out.println("jsonString::"+jsonString);
		return jsonString;
	}

	@RequestMapping(value = "register", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String registerAccount(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// 跨域问题，需要加上
		response.setHeader("Access-Control-Allow-Origin", "*");
		String uAccount = request.getParameter("uAccount");
		String uPassword = request.getParameter("uPassword");
		UserInfo userInfo = new UserInfo(uAccount, uPassword);
		UserInfo register = userInfoService.register(userInfo);
		if (register != null) {
			session.setAttribute("accountInfo", register);
			return "{\"info\":\"success\",\"page\":\"login.html\"}";
		}
		return "{\"info\":\"failure\",\"page\":\"register.html\"}";
	}

	@RequestMapping(value = "modifyAndroid", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String modifyUserInfoAndroid(UserInfo userInfo) {
		UserInfo modifyProfile = userInfoService.modifyProfile(userInfo);
		String jsonString = JSON.toJSONString(modifyProfile);
		System.out.println("modifyUserInfo run  "+jsonString);
		return jsonString;
	}

	// 我已经改了不要动
	@RequestMapping(value = "modify", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String modifyUserInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String uName = request.getParameter("uName");
		String uPassword = request.getParameter("uPassword");
		UserInfo attribute = (UserInfo) session.getAttribute("accountInfo");
		Integer uId = attribute.getuId();
		String uAccount = attribute.getuAccount();
		UserInfo userInfo = new UserInfo(uId, uName, uAccount, uPassword);
		UserInfo modifyProfile = userInfoService.modifyProfile(userInfo);
		session.invalidate();
		return "{\"page\":\"index.action\"}";
	}

	@RequestMapping(value = "login", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		// 跨域问题，需要加上
		response.setHeader("Access-Control-Allow-Origin", "*");
		String uAccount = request.getParameter("uAccount");
		String uPassword = request.getParameter("uPassword");
		UserInfo userInfo = new UserInfo(uAccount, uPassword);

		UserInfo login = userInfoService.login(userInfo);
		if (login != null) {
			session.setAttribute("accountInfo", login);
			return "{\"page\":\"index.action\"}";
		} else
			return "{\"page\":\"login.html\"}";
	}

	@RequestMapping(value = "isLogin", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String isLogin(HttpSession session, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		if (session.getAttribute("accountInfo") == null) {
			return "{\"info\":\"failure\",\"page\":\"login.html\"}";
		} else {
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
		UserInfo userInfo = (UserInfo) session.getAttribute("accountInfo");
		UserInfo login = userInfoService.login(userInfo);
		session.setAttribute("accountInfo", login);
		String jsonString = JSON.toJSONString(login);
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
	public String loginAndroid(UserInfo userInfo, HttpSession session) {
		UserInfo login = userInfoService.login(userInfo);
		System.out.println("张港华++++++++Run" + userInfo.toString());

		if (login != null) {
			session.setAttribute("accountInfoAndroid", login);
			Object attribute = session.getAttribute("accountInfoAndroid");
			System.out.println("accountInfoAndroid Run:->>>>>>>>>>>>>>" + attribute.toString());
			String jsonString = JSON.toJSONString(login);
			return jsonString;
		} else
			return "";

	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

}
