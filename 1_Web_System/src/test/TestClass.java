package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import controller.LoginProcessController;
import model.User;
import dao.HibernateDao;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user=new User();
		Date date=new Date();
		
		user.setId(229376);
		user.setName("aaa");
		user.setPw("123");
		user.setDate(date);
		HibernateDao h=new HibernateDao();
		int effect=0;
		effect=h.updateUser(user);
		
		System.out.println(effect);
		
		
		

		
	}

	
}

 


