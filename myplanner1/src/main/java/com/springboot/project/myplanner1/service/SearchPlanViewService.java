package com.springboot.project.myplanner1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.myplanner1.dao.ISearchPlanViewDAO;
import com.springboot.project.myplanner1.dto.SearchPlanViewDTO;

@Service
public class SearchPlanViewService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public SearchPlanViewDTO getSearchPlan(int code, int planNo, String keyword) {
		
		keyword = "%"+keyword+"%";
		ISearchPlanViewDAO searchPlanViewDao = sqlSession.getMapper(ISearchPlanViewDAO.class);
		
		SearchPlanViewDTO searchPlanViewDto = new SearchPlanViewDTO();
		SearchPlanViewDTO dto = searchPlanViewDao.getSearchPlan(code, planNo, keyword);
		
		searchPlanViewDto.setPageSet(dto.getPageSet());
		searchPlanViewDto.setPageNum(dto.getPageNum());
		searchPlanViewDto.setPlanNo(dto.getPlanNo());
		searchPlanViewDto.setTitle(dto.getTitle());
		searchPlanViewDto.setContent(dto.getContent());
		searchPlanViewDto.setCreatedDate(dto.getCreatedDate());
		searchPlanViewDto.setDoDate(dto.getDoDate());
		searchPlanViewDto.setFinishCheck(dto.getFinishCheck());
		
		return searchPlanViewDto;
	}
}
