package com.zip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zip.service.ServiceInterface;

@Controller
public class AdimController {
	@Autowired
	private ServiceInterface si;
	
	@RequestMapping("/admin")
	public ModelAndView adminLogin(@RequestParam("em") String email,@RequestParam("pwd") String password) {
		
	   ModelAndView mv = new ModelAndView();
	  // mv.addObject("adminEmail",email);
	  // mv.addObject("adminPass",password);
	   
	   si.adminLoginService(email,password);
	   
	   mv.setViewName("Dashboard.jsp");
		return mv;
	}

}
