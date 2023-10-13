package com.springboot.project.myplanner1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchMainPageDTO {
	
	private String keyword;
	
	private String code;
	
	// 페이징  처리를 위한 변수 추가
	private int pageSet;
	private int pageNum;
	private int rowNum;

	private String planNo;
	private String title;
	private String content;
	private String createdDate;
	private String doDate;
	private String finishCheck;
}
