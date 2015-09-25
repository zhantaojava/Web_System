package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.UserBeanProcess;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author suzhantao
 * 
 */
@Controller
public class CopyOfLoginProcessController {

	UserBeanProcess ubp = new UserBeanProcess();

	ModelAndView mv = new ModelAndView();

	/**
	 * 
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView Login(HttpServletRequest request,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		if (ubp.ValidateUser(username, password)) {
			mv = new ModelAndView("wel");

			HttpSession hs = request.getSession();
			hs.setAttribute("user", username);
		} else {
			mv = new ModelAndView("login");
			mv.addObject("ErrorMessage", "invalid user,please try again");
		}

		return mv;
	}

	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public ModelAndView AddUser(HttpServletRequest request,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "age") int age) {

		if (ubp.AddUser(username, password, age)) {
			mv = new ModelAndView("wel");
			mv.addObject("username", username);
			mv.addObject("password", password);
			mv.addObject("age", age);
			mv.addObject("statue", "Create User Successful");

		} else {
			mv = new ModelAndView("wel");
			mv.addObject("statue", "Create User Failue");
		}
		
		
		return mv;

	}

}
