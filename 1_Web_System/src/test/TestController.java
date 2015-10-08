package test;

import model.User;
import model.UserBeanProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestController {
	@Autowired
	UserBeanProcess ubp;
	
	
	@RequestMapping(value="test1")
	public void test1(int count){
		System.out.println(count);
	}
	
	@RequestMapping(value="test2")
	public void test2(@RequestParam("aage")int age, User user){
		System.out.println(user.getName());
		System.out.println(age);

	}
	
	
	@RequestMapping(value="test3")
	public void test3(@ModelAttribute("u") User user){
		System.out.println(user.getName());
		System.out.println(user.getAge());
	}
}
