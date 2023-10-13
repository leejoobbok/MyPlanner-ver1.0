package com.springboot.project.myplanner1.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.project.myplanner1.dto.PlanInsertDTO;
import com.springboot.project.myplanner1.service.PlanInsertService;

@Controller
@RequestMapping("myplanner")
public class PlanInserController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private PlanInsertService planInsertService;
	
	@GetMapping("/planinsertform")
	public String planInsertForm(){
		
		return "PlanInserForm";
	}
	
	@PostMapping("/planinsert")
	public String planInsert(PlanInsertDTO planInsertDto) {
		
		HttpSession session = request.getSession();
		int code = Integer.parseInt((String)session.getAttribute("code"));
	
		planInsertDto.setCode(code);
		planInsertService.planInsert(planInsertDto);
		
		return "redirect:homepage";
		//planView(int code);
	}
}
