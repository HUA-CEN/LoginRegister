package com.interview.LoginRegister.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.LoginRegister.dao.MemberDao;
import com.interview.LoginRegister.entity.MemberEntity;

import com.interview.LoginRegister.vo.BasicOut;
import com.interview.LoginRegister.vo.MemberDetailVO;

@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	public BasicOut<Boolean> register(MemberDetailVO vo) {
		BasicOut<Boolean> result = new BasicOut<>();
		try {
			//因為save裡面只能用entity所以要vo轉成entity
			MemberEntity memberEntity = new MemberEntity();
			BeanUtils.copyProperties(vo, memberEntity);
			memberEntity.setCreateUser("admin");	//這行在處理必填
			memberDao.addOneMember(memberEntity);
			result.setData(true);
		}catch(Exception e) {
			result.setStatus("f");
			result.setMessage(List.of("新增失敗", e.getLocalizedMessage()));
			result.setData(false);
		}
		return result;
	}
}
