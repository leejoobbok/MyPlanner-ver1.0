package com.springboot.project.myplanner1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.myplanner1.dao.IPlanDeleteDAO;
import com.springboot.project.myplanner1.dto.PlanDeleteDTO;

@Service
public class PlanDeleteService {

	@Autowired
	private SqlSession sqlSession;
	
	public void planDelete(PlanDeleteDTO planDeleteDTO) {
		
		IPlanDeleteDAO planDeleteDao = sqlSession.getMapper(IPlanDeleteDAO.class);
		planDeleteDao.planDelete(planDeleteDTO);
	}
}
