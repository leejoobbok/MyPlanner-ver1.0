package com.springboot.project.myplanner1.dao;

import java.util.ArrayList;

import com.springboot.project.myplanner1.dto.PagingDTO;

public interface IPagingDAO {
	
	public int checkPaging(int code);
	public ArrayList<PagingDTO> pagingList(int code, int pageSet);
}
