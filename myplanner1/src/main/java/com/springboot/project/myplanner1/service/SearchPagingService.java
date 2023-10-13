package com.springboot.project.myplanner1.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.myplanner1.dao.ISearchPagingDAO;
import com.springboot.project.myplanner1.dto.SearchPagingDTO;

@Service
public class SearchPagingService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<SearchPagingDTO> searchPagingList(int code, int pageSet, String keyword){
		
		keyword = "%"+keyword+"%";
		ISearchPagingDAO searchPagingDao = sqlSession.getMapper(ISearchPagingDAO.class);
		
		ArrayList<SearchPagingDTO> searchPagingDto = new ArrayList<SearchPagingDTO>();
		
		if (searchPagingDao.checkSearchPaging(code, keyword) > 10) {
			searchPagingDto = searchPagingDao.SearchPagingList(code, pageSet, keyword);
		}
		
		return searchPagingDto;
	}
}
