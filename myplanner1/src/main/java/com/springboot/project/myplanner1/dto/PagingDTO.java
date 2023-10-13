package com.springboot.project.myplanner1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingDTO {
	private int pageSet;
	private int pageNum;
}
