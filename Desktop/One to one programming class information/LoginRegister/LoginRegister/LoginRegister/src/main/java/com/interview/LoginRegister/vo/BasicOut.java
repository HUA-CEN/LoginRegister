package com.interview.LoginRegister.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;

@Getter
@Setter
@Builder	//design pattern是設計模式，Builder就是一種設計模式
@AllArgsConstructor
@NoArgsConstructor
public class BasicOut<T> {
	
	@Default
	private int code = 200;
	@Default
	private String status = "s";	//這個s是涉及來判斷業務邏輯是成更還是失敗，如果成功就回s，如果失敗就回false
	@Default
	private List<String> message = new ArrayList<>();	//這行的message是回，想回給前端的訊息
	
	private T data;

	public void addMessage(String msg) {
		if (message == null) {
			this.message = Collections.singletonList(msg);
		} else {
			this.message.add(msg);
		}
	}
	
	public static <T> BasicOut<T> success(String msg, T data) {
		BasicOut<T> out = new BasicOut<>();
		out.setCode(200);
		out.setStatus("s");
		out.addMessage(msg);
		out.setData(data);
		return out;
	}

	public static <T> BasicOut<T> fail(String msg) {
		BasicOut<T> out = new BasicOut<>();
		out.setCode(401);
		out.setStatus("f");
		out.addMessage(msg);
		out.setData(null);
		return out;
	}
}