package com.springboot.project.myplanner1.dao;

import java.util.ArrayList;

import com.springboot.project.myplanner1.dto.SearchPagingDTO;

public interface ISearchPagingDAO {
	
	public int checkSearchPaging(int code, String keyword);
	public ArrayList<SearchPagingDTO> SearchPagingList(int code, int pageSet, String keyword);
}
