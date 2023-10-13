package com.springboot.project.myplanner1.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.project.myplanner1.service.SearchMainPageService;
import com.springboot.project.myplanner1.service.SearchPagingService;

@Controller
@RequestMapping("myplanner")
public class SearchMainPageController {
	
	@Autowired
	private SearchMainPageService searchMainPageService;
	
	@Autowired
	private SearchPagingService searchPagingService;
	
	@Autowired
	private HttpServletRequest request;
	
	// 검색 결과 출력 & 검색 결과 페이징
	@GetMapping("/searchmainpage")
	public String searchMainPAge(Model model) {
		HttpSession session = request.getSession();
		int code = Integer.parseInt((String)session.getAttribute("code"));
		
		String keyword ="";
		int pageSet = 1;
		int pageNum = 1;
		
		if (request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword");
		}
		if (request.getParameter("pageset") != null) {
			pageSet = Integer.parseInt(request.getParameter("pageset"));
		}
		if (request.getParameter("pagenum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pagenum"));
		}
		
		model.addAttribute("searchplanlist", searchMainPageService.search(code, pageSet, pageNum, keyword));
		model.addAttribute("searchpagelist", searchPagingService.searchPagingList(code, pageSet, keyword));
		
		model.addAttribute("pageset", pageSet);
		model.addAttribute("pagenum", pageNum);
		
		model.addAttribute("keyword", keyword);
		
		return "SearchMainPage";
	}
}
