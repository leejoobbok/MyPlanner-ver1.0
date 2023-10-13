package com.springboot.project.myplanner1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDeleteDTO {

	private int pageSet;
	private int pageNum;
	
	private int code;
	private int planNo;
}
