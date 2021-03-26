package com.wipro.OnlineAssessment.controller;
import java.time.LocalDateTime;
import java.util.List;
import java.time.format.DateTimeFormatter; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.OnlineAssessment.Entity.Results;
import com.wipro.OnlineAssessment.Entity.Users;
import com.wipro.OnlineAssessment.repository.ResultsRepository;
import com.wipro.OnlineAssessment.repository.UsersRepository;

@Controller
public class OnlineAssessmentController {
	@Autowired
	UsersRepository UsersRepository;
	@Autowired
	ResultsRepository ScoreRepository;
	@RequestMapping("/")
	public String login()
	{
	  return "index";
	}
	String Email="";
	String validate;
	@PostMapping("/")
	public String loginCheck(String email,String password)
	{
		Users user = UsersRepository.findByEmail(email);
		Email = email;
		if(user==null)
		{
			validate="NotaUser";
			return "redirect:/login/do";
		}
		if(user.getPassword().equals(password)!=true)
		{
			validate="IncorrectPassword";
			return "redirect:/login/do";
		}
		if(user.getUsertype().equals("admin"))
		{
			validate="Admin";
		    return "redirect:/login/do";
		}
		else
		{
			validate="Candidate";
			return "redirect:/login/do";
		}
	}
	@GetMapping("/login/do")
	public String loginvalidation()
	{
		if(validate=="NotaUser"||validate.equalsIgnoreCase("NotaUser"))
		{
			return "invalidUser";
		}
		else if(validate=="IncorrectPassword"||validate.equalsIgnoreCase("IncorrectPassword"))
		{
			return "passwordError";
		}
		else if(validate=="Admin"||validate.equalsIgnoreCase("Admin"))
		{
			return "selectReports";
		}
		else
			return "selectTest";
	}
	
	@RequestMapping("/register.html")
	public String register()
	{
	  return "register";
	}
	
	String fname="";
	String lname="";
	
	@PostMapping("/register.html")
	public String register(String firstname,String lastname,String email,String password,Model m)
	{
		Users user1 = new Users(firstname,lastname,email,password,"candidate");
		UsersRepository.save(user1);
		fname = firstname;
		lname = lastname;
		return "redirect:/registration/do";
	}
	
	@GetMapping("/registration/do")
	public String registersuccess(Model model)
	{
		model.addAttribute("name",fname + " "+ lname);
		return "registersuccess";
	}
	
	@RequestMapping("/logout")
	public String logout()
	{
	  return "index";
	}
	String ass="";
	LocalDateTime dObj;
	DateTimeFormatter dtObj;
	String date1;
	
	@GetMapping("/springAssessment.html")
	
	public String springtest()
	{
		ass = "Spring-L1";
		dObj = LocalDateTime.now();
	    dtObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    date1 = dObj.format(dtObj);
		return "springAssessment";
	}

	@GetMapping("/hibernateAssessment.html")
	public String hibernatetest()
	{
		ass= "Hibernate-L1";
		dObj = LocalDateTime.now();
	    dtObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    date1 = dObj.format(dtObj);
		return "hibernateAssessment";
	}
	
	
	 @RequestMapping("/evaluate/spring/test")
	 public ModelAndView springtest(@ModelAttribute ("Question1")String ques1,@ModelAttribute ("Question2")String ques2,@ModelAttribute ("Question3")String ques3,@ModelAttribute ("Question4")String ques4,@ModelAttribute ("Question5")String ques5) { 
	 int score=0;
	 if(ques1.equalsIgnoreCase("J2EE App Development Framework"))
		{
			score+=10;
		}if(ques2.equalsIgnoreCase("Inversion Of Control"))
		{
			score+=10;
		}
		if(ques3.equalsIgnoreCase("Aspect Oriented Programming"))
		{
			score+=10;
		}
		if(ques4.equalsIgnoreCase("Application Context"))
		{
			score+=10;
		}
		if(ques5.equalsIgnoreCase("Dispatcher Servlet"))
		{
			score+=10;
		}
		 if(score >=30)
		 {
			 ModelAndView mav=new ModelAndView("testPass");
			 Results test = new Results(ass,date1,score,50,Email,"Passed");
			 ScoreRepository.save(test);
			 return mav;
		 }
		 else
		 {
			 ModelAndView mav=new ModelAndView("testFail");
			 Results test = new Results(ass,date1,score,50,Email,"Failed");
			 ScoreRepository.save(test);
			 return mav;
		 }
	 }
	 @RequestMapping("/evaluate/hibernate/test")
	 public ModelAndView hibernatetest(@ModelAttribute ("Question1")String ques1,@ModelAttribute ("Question2")String ques2,@ModelAttribute ("Question3")String ques3,@ModelAttribute ("Question4")String ques4,@ModelAttribute ("Question5")String ques5) { 
	 int score=0;
		if(ques1.equalsIgnoreCase("Object Relational Mapping"))
		{
			score+=10;
		}if(ques2.equalsIgnoreCase("uni-directional & bi-directional"))
		{
			score+=10;
		}
		if(ques3.equalsIgnoreCase("configuration file"))
		{
			score+=10;
		}
		if(ques4.equalsIgnoreCase("Hibernate Query Language"))
		{
			score+=10;
		}
		if(ques5.equalsIgnoreCase("isolation levels"))
		{
			score+=10;
		}
		if(score >=30)
		 {
			ModelAndView mav=new ModelAndView("testPass");
			 Results test = new Results(ass,date1,score,50,Email,"Passed");
			 ScoreRepository.save(test);
			 return mav;
		 }
		 else
		 {
			 ModelAndView mav=new ModelAndView("testFail");
			 Results test = new Results(ass,date1,score,50,Email,"Failed");
			 ScoreRepository.save(test);
			 return mav;
		 }
	 }
		@RequestMapping("/tests/all")
		public String TestList(Model model)
		{
			List<Results> list = (List<Results>) ScoreRepository.findByTestDate();
			model.addAttribute("test",list);	
			return "listoftesttaken";
		}
		
		@RequestMapping("/users/all")
		public String Userlist(Model model)
		{
			List<Users> list = (List<Users>) UsersRepository.findByName();
			model.addAttribute("user",list);
			return "listofusers";
		}
}

