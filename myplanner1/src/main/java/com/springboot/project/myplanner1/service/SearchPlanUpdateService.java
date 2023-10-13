package com.springboot.project.myplanner1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.myplanner1.dao.ISearchPlanUpdateDAO;
import com.springboot.project.myplanner1.dto.SearchPlanUpdateDTO;

@Service
public class SearchPlanUpdateService {

	@Autowired
	private SqlSession sqlSession;
	
	public SearchPlanUpdateDTO searchPlanUpdateForm(int code, int planNo, String keyword) {
		
		keyword="%"+keyword+"%";
		ISearchPlanUpdateDAO searchPlanUpdateDao = sqlSession.getMapper(ISearchPlanUpdateDAO.class);
		
		return searchPlanUpdateDao.searchPlanUpdateForm(code, planNo, keyword);
	}
	
	public void searchPlanUpdate(SearchPlanUpdateDTO searchPlanUpdateDto) {
		
		ISearchPlanUpdateDAO searchPlanUpdateDao = sqlSession.getMapper(ISearchPlanUpdateDAO.class);
		searchPlanUpdateDao.searchPlanUpdate(searchPlanUpdateDto);
	}
}
