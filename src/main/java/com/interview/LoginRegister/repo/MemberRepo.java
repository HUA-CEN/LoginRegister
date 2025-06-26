package com.interview.LoginRegister.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.interview.LoginRegister.entity.MemberEntity;

public interface MemberRepo extends JpaRepository<MemberEntity, Integer> {
	
	Optional<MemberEntity> findByIdAndPassword(Integer id, String password);
	Optional<MemberEntity> findByIdAndNameAndPassword(Integer id, String name, String password);
	Optional<MemberEntity> findByName(String name);
	List<MemberEntity> findByNameContaining(String name);
	Optional<MemberEntity> findById(Integer id);
	
	void deleteByName(String name);
}
