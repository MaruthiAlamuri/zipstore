package com.zip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zip.entity.Buyer;
import com.zip.entity.Seller;
import com.zip.service.ServiceInterface;

@Controller
public class SellerController {
    @Autowired
	private ServiceInterface si;
	
	private Seller seller;
	@RequestMapping("registration")
	public ModelAndView sellerRegistration(@RequestParam("nm") String name,
			@RequestParam("em") String email,
			@RequestParam("pwd") String password,
			@RequestParam("cPwd") String conformPassword,
			@RequestParam("mob") String mobile,
			@RequestParam("ad") String address)  {
		
		
		
		seller = new Seller();
		seller.setName(name);
		seller.setEmail(email);
		seller.setPassword(password);
		seller.setConformPassword(conformPassword);
		seller.setMobile(mobile);
		seller.setAddress(address);
		
		
		int i= si.sellerRegistrationService(seller);
		
		
		String result ="Registration Failed";
		
		if(i>0) {
			result = "Registration Success";
		}
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("registrationresult", result);
		mv.setViewName("sellerreg.jsp");
		
		
		return mv;		
		
	}
	

	   @RequestMapping("sellerlogin")
	   
	   public ModelAndView sellerLogin(HttpServletRequest request,@RequestParam("em") String email,@RequestParam("pwd") String password){
		  seller= new Seller();
		  seller .setEmail(email);
		  seller.setPassword(password);
		   
		 int i=  si.sellerLoginService(seller);
		  
		 String result ="Login Fail";
		   
		   if(i>0) {
			HttpSession session=request.getSession(true);
			session.setAttribute("myemail",email);
			result="welcome to login page"+email;
		   }
		   
		   ModelAndView mv = new ModelAndView();
		   
		   mv.addObject("loginresult",result);
		   mv.setViewName("sellerlogin.jsp");
		   
		   return mv;
		   
	   }
			
	
	
	
	
}
