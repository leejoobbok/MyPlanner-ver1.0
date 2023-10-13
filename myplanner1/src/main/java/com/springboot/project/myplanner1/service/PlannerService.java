package com.springboot.project.myplanner1.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.myplanner1.dao.IPlannerDAO;
import com.springboot.project.myplanner1.dto.PlannerDTO;

@Service
public class PlannerService {

	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<PlannerDTO> showPlanListHome(int code) {
		
		IPlannerDAO plannerDao = sqlSession.getMapper(IPlannerDAO.class);
		
		ArrayList<PlannerDTO> planList = new ArrayList<PlannerDTO>();
		
		System.out.println("plannerService 게시물 갯수:"+plannerDao.checkPlanList(code));
		
		int pageSet = 1;
		int pageNum = 1;
		
		if (plannerDao.checkPlanList(code) > 0) {
			planList = plannerDao.showPlanListHome(code, pageSet ,pageNum);
		}
		return planList;
	}
	
	public ArrayList<PlannerDTO> showPlanListMain(int code, int pageSet, int pageNum) {
		
		IPlannerDAO plannerDao = sqlSession.getMapper(IPlannerDAO.class);
		
		ArrayList<PlannerDTO> planList = new ArrayList<PlannerDTO>();
		
		System.out.println("plannerService 게시물 갯수:"+plannerDao.checkPlanList(code));
		
		if (plannerDao.checkPlanList(code) > 0) {
			planList = plannerDao.showPlanListMain(code, pageSet ,pageNum);
		}
		return planList;
	}
	
  public String turnFinishCheck(int planNo) {
  
	  IPlannerDAO plannerDao = sqlSession.getMapper(IPlannerDAO.class);
	  plannerDao.turnFinishCheck(planNo);
	  
	  return "완료 여부 변경 완료"; 
  }
	
}
