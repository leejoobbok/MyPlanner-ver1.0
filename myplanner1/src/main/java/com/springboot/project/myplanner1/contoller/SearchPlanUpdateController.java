package com.springboot.project.myplanner1.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.project.myplanner1.dto.SearchPlanUpdateDTO;
import com.springboot.project.myplanner1.service.SearchPlanUpdateService;

@Controller
@RequestMapping("myplanner")
public class SearchPlanUpdateController {

	@Autowired
	private SearchPlanUpdateService searchPlanUpdateService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/searchplan/updateform")
	public ModelAndView searchPlanUpdateForm(ModelAndView mav) {
		
		HttpSession session = request.getSession();
		int code = Integer.parseInt((String)session.getAttribute("code"));
		int planNo = Integer.parseInt(request.getParameter("planno"));
		String keyword = request.getParameter("keyword");
		
		SearchPlanUpdateDTO searchPlanUpdateDto = searchPlanUpdateService.searchPlanUpdateForm(code, planNo, keyword);
		
		mav.setViewName("SearchPlanUpdateForm");
		mav.addObject("searchPlanUpdateDto", searchPlanUpdateDto);
		mav.addObject("keyword", keyword);
		
		return mav;
	}
	
	@PutMapping("/searchplan/update")
	public ModelAndView searchPlanUpdate(SearchPlanUpdateDTO searchPlanUpdateDto) {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		int code = Integer.parseInt((String)session.getAttribute("code"));
		searchPlanUpdateDto.setCode(code);
		
		searchPlanUpdateService.searchPlanUpdate(searchPlanUpdateDto);
		
		mav.setViewName("redirect:/myplanner/searchmainpage/searchplan");
		mav.addObject("planno", searchPlanUpdateDto.getPlanNo());
		mav.addObject("keyword", searchPlanUpdateDto.getKeyword());
		
		return mav;
	}
}
