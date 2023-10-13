package com.springboot.project.myplanner1.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.project.myplanner1.service.PagingService;
import com.springboot.project.myplanner1.service.PlannerService;

@Controller
@RequestMapping("myplanner")
public class MainPageController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private PagingService pagingService;
	
	@GetMapping("/homepage")
	public String homePage(Model model) {
		
		HttpSession session = request.getSession();
		int code = Integer.parseInt((String)session.getAttribute("code"));
		int pageSet = 1;
		int pageNum = 1;
	
		model.addAttribute("planlist", plannerService.showPlanListHome(code));
		model.addAttribute("pagelist", pagingService.pagingList(code, pageSet));
		
		model.addAttribute("pageset", pageSet);
		model.addAttribute("pagenum", pageNum);
		
		return "HomePage";
	}
	
	@GetMapping("/mainpage")
	public String mainPage(Model model) {
		HttpSession session = request.getSession();
		int code = Integer.parseInt((String)session.getAttribute("code"));
		int pageSet = Integer.parseInt(request.getParameter("pageset"));
		int pageNum = Integer.parseInt(request.getParameter("pagenum"));
		
		model.addAttribute("planlist", plannerService.showPlanListMain(code, pageSet, pageNum));
		model.addAttribute("pagelist", pagingService.pagingList(code, pageSet));
		
		model.addAttribute("pageset", pageSet);
		model.addAttribute("pagenum", pageNum);
		
		return "MainPage";
	}
	
	@PostMapping("/turnfinishcheck")
	@ResponseBody
	public String turnFinishCheck() {

		//System.out.println("/turnfinishcheck 컨트롤러 잘 탔음");
		//System.out.println(request.getParameter("planNo"));
		
		int planNo = Integer.parseInt(request.getParameter("planNo"));
		
		//System.out.println("컨트롤러 두 번째"+planNo);
		
		return plannerService.turnFinishCheck(planNo);
	}

}
