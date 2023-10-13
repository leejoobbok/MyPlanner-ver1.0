package com.springboot.project.myplanner1.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.project.myplanner1.dto.PlanViewDTO;
import com.springboot.project.myplanner1.service.PlanViewService;

@Controller
@RequestMapping("myplanner")
public class PlanViewController {

	@Autowired
	private PlanViewService planViewService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/plan")
	public ModelAndView getPlan(ModelAndView mav) {
		
		HttpSession session = request.getSession();
		int code = Integer.parseInt((String)session.getAttribute("code"));
		int planNo = Integer.parseInt(request.getParameter("planno"));
		
		mav.setViewName("PlanView");
		mav.addObject("planviewdto", planViewService.getPlan(code, planNo));
		
		return mav;
	}
}
