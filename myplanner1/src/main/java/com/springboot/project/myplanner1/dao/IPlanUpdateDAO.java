package com.springboot.project.myplanner1.dao;

import org.apache.ibatis.annotations.Param;

import com.springboot.project.myplanner1.dto.PlanUpdateDTO;

public interface IPlanUpdateDAO {
	public PlanUpdateDTO planUpdateForm(@Param("code") int code, @Param("planNo") int planNo);
	public void planUpdate(PlanUpdateDTO planUpdatedto);
}
