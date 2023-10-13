package com.springboot.project.myplanner1.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.springboot.project.myplanner1.dto.PlannerDTO;

public interface IPlannerDAO {
	
	public ArrayList<PlannerDTO> showPlanListHome( @Param("code") int code
												,@Param("pageSet") int pageSet
												,@Param("pageNum") int pageNum);
	
	public ArrayList<PlannerDTO> showPlanListMain( @Param("code") int code
												,@Param("pageSet") int pageSet
												,@Param("pageNum") int pageNum);
	
	public int checkPlanList(int code);
	
	public void turnFinishCheck(@Param("planNo") int planNo);
	
	//public int maxRowNum(int code);
	//public ArrayList<Integer> pageList(int code);
}
