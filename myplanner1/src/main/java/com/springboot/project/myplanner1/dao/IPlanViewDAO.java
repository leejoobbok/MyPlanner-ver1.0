package com.springboot.project.myplanner1.dao;

import org.apache.ibatis.annotations.Param;

import com.springboot.project.myplanner1.dto.PlanViewDTO;

public interface IPlanViewDAO {
	public PlanViewDTO getPlan(@Param("code") int code, 
			                   @Param("planNo") int planNo);
}
