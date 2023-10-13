package com.springboot.project.myplanner1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.myplanner1.dao.IPlanUpdateDAO;
import com.springboot.project.myplanner1.dto.PlanUpdateDTO;

@Service
public class PlanUpdateService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public PlanUpdateDTO planUpdateForm(int code, int planNo) {
		
		IPlanUpdateDAO planUpdateDao = sqlSession.getMapper(IPlanUpdateDAO.class);
		
		return planUpdateDao.planUpdateForm(code, planNo);
	}
	
	public void planUpdate(PlanUpdateDTO planUpdateDto) {
		
		IPlanUpdateDAO planUpdateDao = sqlSession.getMapper(IPlanUpdateDAO.class);
		planUpdateDao.planUpdate(planUpdateDto);
	}
}
