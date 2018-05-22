package com.jike.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
	public String registerAccount(HttpServletRequest request,HttpServletResponse response) {
		//跨域问题，需要加上
		response.setHeader("Access-Control-Allow-Origin", "*");
		UserInfo userInfo=new UserInfo();
		userInfo.setuAccount(request.getParameter("uAccount"));
		userInfo.setuPassword(request.getParameter("uPassWord"));
		userInfo.setuName(request.getParameter("uName"));
		UserInfo register = userInfoService.register(userInfo);
		String jsonString = JSON.toJSONString(register);
		System.out.println("registerAccount run");
		return jsonString;
	}

	@RequestMapping(value = "modifyAndroid", produces = "text/html;charset=UTF-8")
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
	public String loginSuccess(HttpSession session) {
			if(session.getAttribute("accountInfo")!=null)
				return "index";
			else 
				return "login";
	}

	@RequestMapping(value = "modify", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String modifyUserInfo(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		//跨域问题，需要加上
		response.setHeader("Access-Control-Allow-Origin", "*");
		UserInfo userinfo=new UserInfo();
		userinfo.setuId(((UserInfo) session.getAttribute("accountInfo")).getuId());
		if(request.getParameter("uName")!=null)
			userinfo.setuName(request.getParameter("uName"));
		if(request.getParameter("uPassWord")!=null)
			userinfo.setuPassword(request.getParameter("uPassWord"));
		UserInfo modifyProfile = userInfoService.modifyProfile(userinfo);
		String jsonString = JSON.toJSONString(modifyProfile);
		System.out.println("modifyUserInfo run");
		return jsonString;
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
	@ResponseBody
	public String logOut(HttpServletRequest request,HttpServletResponse response) {
		//跨域问题，需要加上
		response.setHeader("Access-Control-Allow-Origin", "*");
		if (request.getSession(false) != null // 如果没有对应的session，返回null，不会创建session
				&& request.getSession().getAttribute("accountInfo") != null) {
			request.getSession().invalidate();
		}
		return "{\"info\":\"success\"}";
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
