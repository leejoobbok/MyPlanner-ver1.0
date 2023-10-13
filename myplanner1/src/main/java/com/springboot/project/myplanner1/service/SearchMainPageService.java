package com.springboot.project.myplanner1.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.myplanner1.dao.ISearchMainPageDAO;
import com.springboot.project.myplanner1.dto.SearchMainPageDTO;

@Service
public class SearchMainPageService {
	
	@Autowired
	private SqlSession sqlSessiom;
	
	
	 public ArrayList<SearchMainPageDTO> search(int code, int pageSet, int pageNum, String keyword) {
		
		 keyword = "%"+keyword+"%";
		 ISearchMainPageDAO searchMainPageDao = sqlSessiom.getMapper(ISearchMainPageDAO.class);
		  
	     ArrayList<SearchMainPageDTO> searchMainPageDto = new ArrayList<SearchMainPageDTO>();
		  
	     if (searchMainPageDao.checkSearch(code, keyword) > 0) {
			
	    	 searchMainPageDto = searchMainPageDao.search(code, pageSet, pageNum, keyword);
		 }
	     
	     return searchMainPageDto;
	 }
	 
}
