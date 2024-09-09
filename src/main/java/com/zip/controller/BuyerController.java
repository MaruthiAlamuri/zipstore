package com.zip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zip.entity.Buyer;
import com.zip.service.ServiceInterface;

@Controller
public class BuyerController {
@Autowired	
private ServiceInterface si;

private Buyer buyer;
@RequestMapping("registration")
public ModelAndView buyerRegistration(@RequestParam("nm") String name , 
		                              @RequestParam("em") String email, 
		                              @RequestParam("pwd") String password ,
		                              @RequestParam("cPwd") String conformPassword,
		                              @RequestParam("ad") String address , 	
		                              @RequestParam("mob") String mobile , 
		                              @RequestParam("gen") String gender ,
		                              @RequestParam("pin") String pinCode){
	
	buyer = new Buyer();
	
	buyer.setName(name);
	buyer.setEmail(email);
	buyer.setPassword(password);
	buyer.setConformPassword(conformPassword);
	buyer.setAddress(address);
	buyer.setMobile(mobile);
	buyer.setGender(gender);
	buyer.setPincode(pinCode);
	
	int i= si.buyerRegistrationService(buyer);
	
	String result = "Registration Fail";
	
	if(i>0) {
		result="Registration Sucess";
	}
	ModelAndView mv = new ModelAndView();
	
	mv.addObject("registrationresult",result);
	mv.setViewName("reg.jsp");

    return mv;
	
   }

   @RequestMapping("login")
   
   public ModelAndView buyerLogin(HttpServletRequest request,@RequestParam("em") String email,@RequestParam("pwd") String password){
	   buyer = new Buyer();
	   buyer.setEmail(email);
	   buyer.setPassword(password);
	   
	 int i=  si.buyerLoginService(buyer);
	  
	 String result ="Login Fail";
	   
	   if(i>0) {
		HttpSession session=request.getSession(true);
		session.setAttribute("myemail",email);
		result="welcome to login page"+email;
	   }
	   
	   ModelAndView mv = new ModelAndView();
	   
	   mv.addObject("loginresult",result);
	   mv.setViewName("login.jsp");
	   
	   return mv;
	   
   }
		
	
}
