package com.springboot.project.myplanner1.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.springboot.project.myplanner1.dao.ILoginDAO;
import com.springboot.project.myplanner1.dto.LoginDTO;
import com.springboot.project.myplanner1.service.LoginService;

@Controller
@RequestMapping("myplanner")
public class LoginFormController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/loginform")
	public String loginsform() {
		
		return "LoginForm";
	}
	
	@PostMapping("/checklogin")
	@ResponseBody
	public int checkLogin(LoginDTO logindto){
		
		int result = 0;
		
		if(loginService.checkLogin(logindto) > 0) {
			result = 1;
		}
	
		return result;
	}
	
	@PostMapping("/login")
	public String login(LoginDTO logindto) {
		HttpSession session = request.getSession();
		String code = loginService.getCode(logindto);
		session.setAttribute("code", code);
		return "redirect:homepage";
	}
	
	@GetMapping("/logout")
	public String logout() {
		HttpSession session = request.getSession();
		session.removeAttribute("code");
		
		return "redirect:loginform";
	}
}
