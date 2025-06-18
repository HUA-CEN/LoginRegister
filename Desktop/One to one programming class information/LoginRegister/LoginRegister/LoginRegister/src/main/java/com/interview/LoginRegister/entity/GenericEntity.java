package com.interview.LoginRegister.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass  //JPA的東西，代表這個Entity不是一張獨立的表，是附屬在其他Entity下面的表
@Getter
@Setter
public abstract class GenericEntity implements Serializable {

	@Column(name = "CREATOR", length = 20, nullable = false)
	private String createUser;
	@Column(name = "CREATETIME", nullable = false)
	private LocalDateTime createTime;
	@Column(name = "MODIFIER", length = 20)
	private String updateUser;
	@Column(name = "LASTUPDATE")
	private LocalDateTime updateTime;
	
	@PrePersist  //@PrePersist是指在執行這個物件前，會先insert這個方法
	public void Prepersist() {
		if(Objects.isNull(createTime)) {
			this.createTime = LocalDateTime.now();
		}
		
		if(Objects.isNull(updateTime)) {
			this.updateTime = this.createTime();
		}
		
		if(Objects.isNull(updateUser) && Objects.nonNull(createUser)) {
			this.updateUser = this.createUser();
		}
	}

	private String createUser() {
		return null;
	}
	private LocalDateTime createTime() {
		return null;
	}


	@jakarta.persistence.PreUpdate
	public void PreUpdate() {
		this.updateTime = LocalDateTime.now();
	}
}

