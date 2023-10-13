package com.springboot.project.myplanner1.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.project.myplanner1.service.SearchPlanViewService;

@Controller
@RequestMapping("myplanner")
public class SearchPlanViewController {

	@Autowired
	private SearchPlanViewService searchPlanViewService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/searchmainpage/searchplan")
	public ModelAndView getSearchPlan(ModelAndView mav) {
		
		HttpSession session = request.getSession();
		int code = Integer.parseInt((String)session.getAttribute("code"));
		int planNo = Integer.parseInt((String)request.getParameter("planno"));
		String keyword = request.getParameter("keyword");
		
		mav.setViewName("SearchPlanView");
		mav.addObject("searchplanviewdto", searchPlanViewService.getSearchPlan(code, planNo, keyword));
		mav.addObject("keyword", keyword);

		return mav;
	}
}
