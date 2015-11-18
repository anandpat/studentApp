package com.anand.studentApp.controllers;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.anand.studentApp.hibernate.dao.StudentDaoImpl;
import com.anand.studentApp.models.PasswordChange;
import com.anand.studentApp.models.Role;
import com.anand.studentApp.models.User;
import com.anand.studentApp.viewBeans.UserLoginBean;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("User")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

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
		 * model.addAttribute("serverTime", formattedDate);
		 */

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("UserLoginBean") UserLoginBean userLoginBean, Model model) {
		// model.addAttribute("UserLoginBean", userLoginBean);
		StudentDaoImpl daoImpl = new StudentDaoImpl();

		User user = daoImpl.getUser(userLoginBean.getUserName());
		if (user != null && user.getPassword().equals(userLoginBean.getPassword())) {
			// model.addAttribute("message", "hello world!!");
			model.addAttribute("user", user);
			model.addAttribute("User", userLoginBean);
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
		StudentDaoImpl daoImpl = new StudentDaoImpl();
		boolean pass = daoImpl.forgotPassChange(passwordChange);

		if (pass) {
			return "passChangeSuccess";
		}
		return "passChangeFail";
	}
	
	@RequestMapping("/viewInfo")
	public String viewUserInfo(){
		
		return null;
		
	}

}
