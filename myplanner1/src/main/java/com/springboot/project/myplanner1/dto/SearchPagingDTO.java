package com.springboot.project.myplanner1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPagingDTO {
	
	private String keyword;
	
	private int pageSet;
	private int pageNum;
}
