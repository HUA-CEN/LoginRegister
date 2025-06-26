package com.interview.LoginRegister.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.LoginRegister.dao.MemberDao;
import com.interview.LoginRegister.entity.MemberEntity;

import com.interview.LoginRegister.vo.MemberDetailVO;

@Service
public class LoginRegisterService {
	
	@Autowired
	private MemberDao memberDao;
	
	public Boolean login(MemberDetailVO vo) {
		Optional<MemberEntity> memberEntity = memberDao.queryOneMember(vo);
		//驗證的邏輯
		if(memberEntity.isPresent()) {
			return memberEntity.get().getPassword().equals(vo.getPassword());
		}else {
			//db沒資料，代表登入一定失敗
			return false;
		}
	}
}