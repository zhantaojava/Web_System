package controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserBeanProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
public class LoginProcessController {

	@Autowired
	UserBeanProcess ubp;

	ModelAndView mv = new ModelAndView();

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "loginValidation", method = RequestMethod.POST)
	public String LoginValidation(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		String url = null;
		if (ubp.ValidateUser(username, password)) {
			System.out.println("loginValidation hit");
			return "redirect:retrieveUser";

		} else {
			url = "index";
		}

		return url;
	}

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
			mv = new ModelAndView("redirect:retrieveUser");
			mv.addObject("username", username);
			mv.addObject("password", password);
			mv.addObject("age", age);
			mv.addObject("statue", "Create User Successful");

		} else {
			mv = new ModelAndView("register");
			mv.addObject("statue", "Create User Failue");
		}

		return mv;

	}

	/**
	 * call from GetUser
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "user/{username}", method = RequestMethod.GET)
	public ModelAndView GetUserProfile(@PathVariable String username) {

		mv = new ModelAndView("userProfile");
		System.out.println("uname:" + username);

		User user = new User();

		user = ubp.GetUserProfile(username);

		mv.addObject("user", user);

		return mv;

	}

	/**
	 * call GetUserProfile ,path username to user/{username}
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "getUser", method = RequestMethod.GET)
	public String GetUser(@RequestParam(value = "username") String username) {

		return "redirect:user/" + username;

	}

	/**
	 * 
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "retrieveUser", method = RequestMethod.GET)
	public ModelAndView RetrieveUser(HttpServletRequest request) {
		String s_pageNow = request.getParameter("pageNow");
		System.out.println("s_pageNow:" + s_pageNow);

		int pageNow = 1;
		if (s_pageNow != null) {
			pageNow = Integer.parseInt(s_pageNow);
		} else {
			pageNow = 1;
		}

		int pageSize = 3;

		System.out.println("retrieveUser");

		List<User> list = new LinkedList();

		list = ubp.RetrieveUser(pageNow, pageSize);

		mv = new ModelAndView("wel");

		mv.addObject("userList", list);

		return mv;

	}

}
