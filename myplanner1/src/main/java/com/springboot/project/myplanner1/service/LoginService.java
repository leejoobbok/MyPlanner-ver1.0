package com.springboot.project.myplanner1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.myplanner1.dao.ILoginDAO;
import com.springboot.project.myplanner1.dto.LoginDTO;

@Service
public class LoginService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int checkLogin(LoginDTO loginDto) {
		
		ILoginDAO loginDao = sqlSession.getMapper(ILoginDAO.class);
		
		int checkId = 0;
		
		// 계정 존재하면
		if (loginDao.checkLogin(loginDto) > 0) {
			checkId = 1;
		}
		
		return checkId;
	}
	
	public String getCode(LoginDTO loginDto) {
		
		ILoginDAO loginDao = sqlSession.getMapper(ILoginDAO.class);
		
		return loginDao.getCode(loginDto);
	}
}
