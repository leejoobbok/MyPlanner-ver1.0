package com.springboot.project.myplanner1.dao;

import org.apache.ibatis.annotations.Param;

import com.springboot.project.myplanner1.dto.SearchPlanViewDTO;

public interface ISearchPlanViewDAO {
	
	public SearchPlanViewDTO getSearchPlan(@Param("code") int code
										 , @Param("planNo") int planNo
										 , @Param("keyword") String keyword);
}
