package com.springboot.project.myplanner1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AccountManageDTO {

	private String userName;
	private String password;
	
	public void createdto(AccountManageDTO dto) {
		this.userName = dto.getUserName();
		this.password = dto.getPassword();
	}
	
	public void withdrawdto(String password){
		this.password = password;
	}
}
