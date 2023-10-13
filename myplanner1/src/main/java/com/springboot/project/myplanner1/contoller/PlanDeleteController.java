package com.springboot.project.myplanner1.contoller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.project.myplanner1.dto.PlanDeleteDTO;
import com.springboot.project.myplanner1.service.PlanDeleteService;

@Controller
@RequestMapping("myplanner")
public class PlanDeleteController {

	@Autowired
	private PlanDeleteService planDeleteService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/plandelete")
	public ModelAndView planDelete(int planno, int pageset, int pagenum) {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		int code =  Integer.parseInt((String)session.getAttribute("code"));
		int planNo = planno;
				
		PlanDeleteDTO planDeleteDto = new PlanDeleteDTO();
		planDeleteDto.setCode(code);
		planDeleteDto.setPlanNo(planNo);
		
		planDeleteService.planDelete(planDeleteDto);
		
		mav.setViewName("redirect:mainpage");
		mav.addObject("pageset", pageset);
		mav.addObject("pagenum", pagenum);
	
		return mav;
	}
}
