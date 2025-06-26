package com.interview.LoginRegister.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table(name = "MEMBER")	//UK and Index 在這邊設定
@Entity
@ToString
	
public class MemberEntity extends GenericEntity{
	
	@Id	//PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//使用資料庫自動新增資料
	
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "AGE")
	private Integer age;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD" , length = 50)
	private String password;
	
	@Lob
	@Column(name = "image", columnDefinition = "LONGBLOB")
	//@Column(name = "IMAGE", columnDefinition = "varbinary(max)")；varbinary(max)是SQL Server(微軟資料庫)的語法，LONGBLOB才是MySQL的
	private byte[] profileImage;
}

