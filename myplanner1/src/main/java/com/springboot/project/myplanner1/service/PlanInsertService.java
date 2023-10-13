package com.springboot.project.myplanner1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.myplanner1.dao.IPlanInsertDAO;
import com.springboot.project.myplanner1.dto.PlanInsertDTO;

@Service
public class PlanInsertService {

	@Autowired
	private SqlSession sqlSession;
	
	// 일정 등록
	public void planInsert(PlanInsertDTO planInsertDto) {
		IPlanInsertDAO planInsertDao = sqlSession.getMapper(IPlanInsertDAO.class);
		planInsertDao.planInsert(planInsertDto);
	}
}
