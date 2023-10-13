package com.springboot.project.myplanner1.dao;

import org.apache.ibatis.annotations.Param;

import com.springboot.project.myplanner1.dto.SearchPlanUpdateDTO;

public interface ISearchPlanUpdateDAO {
	public SearchPlanUpdateDTO searchPlanUpdateForm(@Param("code") int code, @Param("planNo") int planNo, @Param("keyword") String keyword);
	public void searchPlanUpdate(SearchPlanUpdateDTO searchPlanUpdatedto);
}
