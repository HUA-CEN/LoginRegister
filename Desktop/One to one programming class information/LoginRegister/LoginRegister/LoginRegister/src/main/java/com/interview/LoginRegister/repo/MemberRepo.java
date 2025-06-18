package com.interview.LoginRegister.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.interview.LoginRegister.entity.MemberEntity;

public interface MemberRepo extends JpaRepository<MemberEntity, Integer> {
	
	Optional<MemberEntity> findByIdAndPasword(Integer id, String password);
	Optional<MemberEntity> findByIdNameAndPasword(String name, String password);
	Optional<MemberEntity> findByName(String name);
	List<MemberEntity> findByIdAndContaining(String name);
	
	void deleteByName(String name);
}
