package com.springboot.project.myplanner1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.myplanner1.dao.IPlanViewDAO;
import com.springboot.project.myplanner1.dto.PlanViewDTO;

@Service
public class PlanViewService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public PlanViewDTO getPlan(int code, int planNo) {
		
		IPlanViewDAO planViewDao = sqlSession.getMapper(IPlanViewDAO.class);
		
		PlanViewDTO planViewDto = new PlanViewDTO();
		PlanViewDTO dto = planViewDao.getPlan(code, planNo);
		
		planViewDto.setPageSet(dto.getPageSet());
		planViewDto.setPageNum(dto.getPageNum());
		planViewDto.setPlanNo(dto.getPlanNo());
		planViewDto.setTitle(dto.getTitle());
		planViewDto.setContent(dto.getContent());
		planViewDto.setCreatedDate(dto.getCreatedDate());
		planViewDto.setDoDate(dto.getDoDate());
		planViewDto.setFinishCheck(dto.getFinishCheck());
		
		return planViewDto;
	}
}
