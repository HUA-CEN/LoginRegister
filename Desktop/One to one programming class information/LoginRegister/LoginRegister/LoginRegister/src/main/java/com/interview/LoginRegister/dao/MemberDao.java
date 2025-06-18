package com.interview.LoginRegister.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interview.LoginRegister.entity.MemberEntity;
import com.interview.LoginRegister.repo.MemberRepo;

import com.interview.LoginRegister.vo.MemberDetailVO;

@Repository   
public class MemberDao {
	
	@Autowired
	private MemberRepo memberRepo;
	
	public Optional<MemberEntity> queryOneMember(MemberDetailVO vo) {
		return memberRepo.findByName(vo.getName());
	}
	
	public void addOneMember(MemberEntity entity) {
		memberRepo.save(entity);
	}
}