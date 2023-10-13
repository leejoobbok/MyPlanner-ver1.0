package com.springboot.project.myplanner1.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.myplanner1.dao.IPagingDAO;
import com.springboot.project.myplanner1.dto.PagingDTO;

@Service
public class PagingService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<PagingDTO> pagingList(int code, int pageSet){
		
		IPagingDAO pagingDao = sqlSession.getMapper(IPagingDAO.class);
		
		ArrayList<PagingDTO> pagingList = new ArrayList<PagingDTO>();
		
		// 이 계정의 게시물 수가 10개가 넘는다면 -> 페이지 인덱스가 2개 이상 필요하다면
		if (pagingDao.checkPaging(code) > 10) {
			pagingList = pagingDao.pagingList(code, pageSet);
		}
		
		return pagingList;
	}
}
