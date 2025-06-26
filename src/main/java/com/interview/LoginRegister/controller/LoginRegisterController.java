package com.interview.LoginRegister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.LoginRegister.service.LoginRegisterService;
import com.interview.LoginRegister.service.MemberService;

import com.interview.LoginRegister.vo.BasicOut;
import com.interview.LoginRegister.vo.MemberDetailVO;

@RestController  
@RequestMapping(value = "/login")
public class LoginRegisterController {
	
	@Autowired
	private LoginRegisterService loginregisterservice;
	@Autowired
	private MemberService memberService;

	//會員登錄用
	@PostMapping("/login")
	public BasicOut login(@RequestBody MemberDetailVO vo) {
  	boolean result = loginregisterservice.login(vo);
  		 
  	if (result) {
  		return BasicOut.success("登入成功", null);
  	} else {
  		return BasicOut.fail("帳號或密碼錯誤");
  	}
	}
	
	
	//註冊會員用
	@PostMapping(value = "register")
	public BasicOut<Boolean> register(@RequestBody MemberDetailVO vo) {
		BasicOut<Boolean> result = new BasicOut<>();
		// 驗證必填寫的欄位是否是空字串，或是null
		if (!StringUtils.hasText(vo.getName())) {	//沒有name的話就結束
			result.setData(false);
			result.setStatus("f");
			result.setMessage(List.of("Name不可為空"));
			return result;
		}	//繼續驗證
		if (!StringUtils.hasText(String.valueOf(vo.getAge()))) {
			result.setData(false);
			result.setStatus("f");
			result.setMessage(List.of("Age不可為空"));
			return result;
		}
		if (!StringUtils.hasText(vo.getEmail())) {
			result.setData(false);
			result.setStatus("f");
			result.setMessage(List.of("Email不可為空"));
			return result;
		}
		return memberService.register(vo);
	}
}