package com.anand.studentApp.controllers;


import java.util.List;
import java.util.Locale;

import javax.persistence.EnumType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.anand.studentApp.hibernate.dao.StudentDaoImpl;
import com.anand.studentApp.models.Branch;
import com.anand.studentApp.models.ContactInfo;
import com.anand.studentApp.models.PasswordChange;
import com.anand.studentApp.models.Role;
import com.anand.studentApp.models.Sex;
import com.anand.studentApp.models.User;
import com.anand.studentApp.viewBeans.UserLoginBean;

/**
 * Handles requests for the application home page.
 */
@Controller
@Scope("session")

public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private  StudentDaoImpl daoImpl = new StudentDaoImpl();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// http://localhost:8080/studentApp/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute("UserLoginBean") UserLoginBean userLoginBean, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("UserLoginBean", userLoginBean);
		/*
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
		 * locale);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 * 
		 *      model.addAttribute("serverTime", formattedDate);
		 */

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("UserLoginBean") UserLoginBean userLoginBean, Model model,HttpServletRequest request,HttpServletResponse response) {
		// model.addAttribute("UserLoginBean", userLoginBean);
		
		response.setContentType("image/jpeg");
		User user = daoImpl.getUser(userLoginBean.getUserName());
		if (user != null && user.getPassword().equals(userLoginBean.getPassword())) {
			// model.addAttribute("message", "hello world!!");
			model.addAttribute("user", user);
			model.addAttribute("User", userLoginBean);
			
			request.getSession().setAttribute("userInSession",user);
			
			if (user.getRole().equals(Role.STUDENT)) {
				return "studentHome";
			}
			if (user.getRole().equals(Role.TEACHER)) {
				return "teacherHome";
			}
			if (user.getRole().equals(Role.ADMIN)) {
				return "adminHome";
			}

			if (user.getRole().equals(Role.TPO)) {
				return "tpoHome";
			}
		}
		return "LoginError";
	}

	@RequestMapping(value = "/forgotPwd", method = RequestMethod.GET)
	public String forgotPass(@ModelAttribute("PasswordChange") PasswordChange passwordChange, Model model) {
		/*ArrayList<String> questionList = new ArrayList<String>();
		questionList.add("what is your home town?");
		questionList.add("what is your parent name?");*/
		model.addAttribute("passwordChange", passwordChange);
	//	model.addAttribute("questionList", questionList);
		return "passChange";

	}

	@RequestMapping(value = "/validatePassChange", method = RequestMethod.POST)
	public String validatPassChange(@ModelAttribute("PasswordChange") PasswordChange passwordChange, Model model) {
		model.addAttribute("passwordChange", passwordChange);
		 
		boolean pass = daoImpl.forgotPassChange(passwordChange);

		if (pass) {
			return "passChangeSuccess";
		}
		return "passChangeFail";
	}
	
	@RequestMapping("/viewInfo")
	public String viewUserInfo(HttpServletRequest request, Model model){
		User user = (User)request.getSession().getAttribute("userInSession");
		model.addAttribute("user", user);
		logger.info("userInSession is : {}.", user);
		logger.info("contact info is : {}.",user.getContactInfo());
		return "viewInfo";
		
	}
	
	@RequestMapping("/editProfile")
	public String editProfile(HttpServletRequest request, Model model){
		User user = (User)request.getSession().getAttribute("userInSession");
		model.addAttribute("user", user);
		
		return "editProfile";
	}
	
	@RequestMapping("/updateProfile")
	public String updateProfile(@RequestParam("userName") String userName,@RequestParam("fullName") String fullName,
			@RequestParam("branch") String branch,@RequestParam("role") String role,
			@RequestParam("sex") String sex,@RequestParam("parentName") String parentName,@RequestParam("primaryAdd") String primaryAdd,
			@RequestParam("secondaryAdd") String secondaryAdd,@RequestParam("homePhone") String homePhone,
			@RequestParam("mobileNum") String mobileNum,HttpServletRequest request,Model model){
		logger.info("update profile for userName  : {} fullName:{}", 
				userName,fullName);
		logger.info("branch:{} role:{}",branch,role);
		logger.info("sex:{} parentName {}",sex,parentName);
		logger.info("primaryAdd:{} secondaryAdd:{}",primaryAdd,secondaryAdd);
		logger.info("homePhone:{} mobileNum:{}",homePhone,mobileNum);
		
		User user = (User)request.getSession().getAttribute("userInSession");
		
		User UpdateUser= new User();
		UpdateUser.setUserName(userName);
		UpdateUser.setFullName(fullName);
		UpdateUser.setBranch(Enum.valueOf(Branch.class, branch));
		UpdateUser.setSex(Enum.valueOf(Sex.class,sex));
		UpdateUser.setRole(Enum.valueOf(Role.class,role));
		UpdateUser.setPassword(user.getPassword());
		ContactInfo contactInfo= new ContactInfo();
		contactInfo.setUserName(UpdateUser.getUserName());
		contactInfo.setParentName(parentName);
		contactInfo.setPrimaryAdd(primaryAdd);
		contactInfo.setSecondaryAdd(secondaryAdd);
		contactInfo.setHomePhone(homePhone);
		contactInfo.setMobileNum(mobileNum);
		contactInfo.setUser(UpdateUser);
		
		UpdateUser.setContactInfo(contactInfo);
		
		daoImpl.updateUser(UpdateUser);
		request.getSession().removeAttribute("userInSession");
		request.getSession().setAttribute("userInSession",UpdateUser);
		
		model.addAttribute("user",UpdateUser );
		return "updateProfile";
	}
	
	@RequestMapping("/viewStudents")
	public String viewAllStudents(Model model){
		List<User> studentList= daoImpl.getAllStudents();
		model.addAttribute("studentList",studentList);
		
		return "viewStudents";
		
	}
	
	@RequestMapping("/viewTeachers")
	public String viewAllTeachers(Model model){
		List<User> teacherList= daoImpl.getAllTeachers();
		model.addAttribute("teacherList",teacherList);
		
		return "viewTeachers";
		
	}
	
	@RequestMapping("/viewTPO")
	public String viewAllTPO(Model model){
		List<User> tpoList= daoImpl.getAllTPO();
		model.addAttribute("tpoList",tpoList);
		
		return "viewTPO";
		
	}
	
	@RequestMapping("/addUser")
	public String addUser(Model model){
		
		return "addUser";
		
	}
	
	@RequestMapping("/addNewUser")
	public String addNewUser(@RequestParam("userName") String userName,@RequestParam("password") String password,@RequestParam("fullName") String fullName,
			@RequestParam("branch") String branch,@RequestParam("role") String role,
			@RequestParam("sex") String sex,@RequestParam("parentName") String parentName,@RequestParam("primaryAdd") String primaryAdd,
			@RequestParam("secondaryAdd") String secondaryAdd,@RequestParam("homePhone") String homePhone,
			@RequestParam("mobileNum") String mobileNum,Model model){
		
		logger.info("addNewUser for userName  : {} fullName:{}", 
				userName,fullName);
		logger.info("password  : {}",password );
		logger.info("branch:{} role:{}",branch,role);
		logger.info("sex:{} parentName {}",sex,parentName);
		logger.info("primaryAdd:{} secondaryAdd:{}",primaryAdd,secondaryAdd);
		logger.info("homePhone:{} mobileNum:{}",homePhone,mobileNum);
		
		User newUser= new User();
		newUser.setUserName(userName);
		
		
		/*if(daoImpl.getUser(userName)==null && !(userName.isEmpty()) && !(userName.equals(""))){
			model.addAttribute("availability", "UserName Available!!");
			model.addAttribute("userName",userName);
			return "addUser";
		}else if(daoImpl.getUser(userName)!=null || (userName.isEmpty()) ){
			model.addAttribute("availability", " UserName not Available!!");
			model.addAttribute("userName",userName);
			return "addUser";
			
			
		}*/
		
		if(daoImpl.getUser(userName)!=null || (userName.isEmpty()) ){
			model.addAttribute("availability", " UserName not Available!!");
			model.addAttribute("userName",userName);
			return "addUser";
		}
		
		if(daoImpl.getUser(userName)==null && !(userName.isEmpty()) && !(userName.equals(""))){
			model.addAttribute("availability", "UserName Available!!");
			model.addAttribute("userName",userName);
		
		}
		newUser.setFullName(fullName);
		if(!(branch.equals(""))){
		newUser.setBranch(Enum.valueOf(Branch.class, branch));
		}
		if(!(sex.equals(""))){
		newUser.setSex(Enum.valueOf(Sex.class,sex));
		}
		if(!(role.equals(""))){
		newUser.setRole(Enum.valueOf(Role.class,role));
		}
		newUser.setPassword(password);
		ContactInfo contactInfo= new ContactInfo();
		
		//contactInfo.setUserName(newUser.getUserName());
		contactInfo.setParentName(parentName);
		contactInfo.setPrimaryAdd(primaryAdd);
		contactInfo.setSecondaryAdd(secondaryAdd);
		contactInfo.setHomePhone(homePhone);
		contactInfo.setMobileNum(mobileNum);
		contactInfo.setUser(newUser);
		
		newUser.setContactInfo(contactInfo);
		if(!(branch.equals("")) && !(sex.equals("")) && !(role.equals("")) ){
			daoImpl.addNewUser(newUser);
			if(newUser.getRole().equals(Enum.valueOf(Role.class, "STUDENT"))){
				model.addAttribute("message", "New Student Added!!!");
				List<User> studentList= daoImpl.getAllStudents();
				model.addAttribute("studentList",studentList);
				return "viewStudents";
			}else if(newUser.getRole().equals(Enum.valueOf(Role.class, "TEACHER"))){
				model.addAttribute("message", "New Teacher Added!!!");
				List<User> teacherList= daoImpl.getAllTeachers();
				model.addAttribute("teacherList",teacherList);
				return "viewTeachers";
			}
			else if(newUser.getRole().equals(Enum.valueOf(Role.class, "TPO"))){
				model.addAttribute("message", "New TPO Added!!!");
				List<User> tpoList= daoImpl.getAllTPO();
				model.addAttribute("tpoList",tpoList);
				return "viewTPO	";
			}
		} 
		
		return "addUser";
		
	}
	
	@RequestMapping("/changeMyPass")
	public String changeMyPassword(HttpServletRequest request,Model model){
		
		User user = (User)request.getSession().getAttribute("userInSession");
		logger.info("user in session is {} ", user );
		model.addAttribute("user",user);
		return "changeMyPass";
		
	}
		
	@RequestMapping("/manualPassChange")
	public String manualPassChange(HttpServletRequest request,Model model ,@RequestParam("currPass") String currPass,@RequestParam("newPass") String newPass,
			@RequestParam("confirmNewPass") String confirmNewPass){
		
		String passChangeMessage= "";
		
		User user = (User)request.getSession().getAttribute("userInSession");
		logger.info("user in session is {} ", user );
		
		if(currPass!=null && !(currPass.equals(user.getPassword()))){
			passChangeMessage= "current password enterd is not matching with user password!!";
			model.addAttribute("passChangeMessage",passChangeMessage);
			return "changeMyPass";
		}
		
		if (newPass!=null && confirmNewPass!=null && !(newPass.equals(confirmNewPass))){
			passChangeMessage= "Both occurence of new password is not matching!!";
			model.addAttribute("passChangeMessage",passChangeMessage);
			return "changeMyPass";
		}
		
		daoImpl.changePassword(user.getUserName(), newPass);
		passChangeMessage="password changed successfully ";
		model.addAttribute("passChangeMessage",passChangeMessage);
		model.addAttribute("user",user);
		return "viewInfo";
		
	}
	
	

}
