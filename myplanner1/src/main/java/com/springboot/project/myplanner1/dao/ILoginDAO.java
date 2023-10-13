package com.springboot.project.myplanner1.dao;

import com.springboot.project.myplanner1.dto.LoginDTO;

public interface ILoginDAO {
	
	public int checkLogin(LoginDTO logindto);
	public String getCode(LoginDTO logindto);
}
