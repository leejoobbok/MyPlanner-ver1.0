package com.springboot.project.myplanner1.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.springboot.project.myplanner1.dto.SearchMainPageDTO;

public interface ISearchMainPageDAO {

	public int checkSearch(@Param("code") int code, @Param("keyword")String keyword);
	public ArrayList<SearchMainPageDTO> search(@Param("code") int code, @Param("pageSet") int pageSet, @Param("pageNum") int pageNum, @Param("keyword") String keyword);

}
