package com.interview.LoginRegister.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDetailVO {
	
	private String name; //姓名
	
	private String password;
	
	private String email; //帳號
	
	private Integer age;
}