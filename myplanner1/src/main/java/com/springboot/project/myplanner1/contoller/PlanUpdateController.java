package com.springboot.project.myplanner1.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.project.myplanner1.dto.PlanUpdateDTO;
import com.springboot.project.myplanner1.service.PlanUpdateService;

@Controller
@RequestMapping("myplanner")
public class PlanUpdateController {
	
	@Autowired
	private PlanUpdateService planUpdateService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/planupdateform")
	public ModelAndView planUpdateForm(ModelAndView mav) {
		
		HttpSession session = request.getSession();
		int code = Integer.parseInt((String)session.getAttribute("code"));
		int planNo =  Integer.parseInt(request.getParameter("planno"));
		
		PlanUpdateDTO planUpdateDto = planUpdateService.planUpdateForm(code, planNo);
		
		mav.setViewName("PlanUpdateForm");
		mav.addObject("planUpdateDto", planUpdateDto);
		
		return mav;
	}
	
	@PutMapping("/planupdate")
	public ModelAndView planUpdate(PlanUpdateDTO planUpdateDto) {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		int code = Integer.parseInt((String)session.getAttribute("code"));
		planUpdateDto.setCode(code);
		
		planUpdateService.planUpdate(planUpdateDto);
		
		mav.setViewName("redirect:plan");
		mav.addObject("planno", planUpdateDto.getPlanNo());
		
		return mav;
	}
	

}
