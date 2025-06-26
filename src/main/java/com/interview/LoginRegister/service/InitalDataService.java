package com.interview.LoginRegister.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.interview.LoginRegister.entity.MemberEntity;
import com.interview.LoginRegister.repo.MemberRepo;

@Component
public class InitalDataService {
	
	@Autowired
	private MemberRepo memberRepo;
	
	@EventListener(ApplicationReadyEvent.class)
	public void doForDbInitiaData() {
		initMemberData();
	}
	
	private void initMemberData() {		
		if(memberRepo.count() == 0) {
			List<MemberEntity>list = new ArrayList<>();
			MemberEntity member = new MemberEntity();
			member.setName("ADMIN");
			member.setPassword("ADMIN");
			member.setCreateUser("INIT");
			list.add(member);

			MemberEntity member2 = new MemberEntity();
			member2.setName("ADMIN2");
			member2.setPassword("ADMIN2");
			member2.setCreateUser("INIT");
			list.add(member2);
			
			memberRepo.saveAll(list);
		}
	}
}