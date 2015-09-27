package test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.User;
import dao.HibernateDao;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		List list = new ArrayList();

		
		list=abc.haha();
		// list=h.searchPage(1, 15);

		for (int i = 0; i < list.size(); i++) {
			User u = new User();
			u = (User) list.get(i);
			System.out.println(u.getName() + " ---  " + u.getAge());
		}

		//System.out.println(h.SearchPageCount(3));
	}

	
}

 


