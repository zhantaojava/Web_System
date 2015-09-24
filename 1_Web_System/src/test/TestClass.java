package test;

import java.util.ArrayList;
import java.util.List;

import model.User;
import dao.HibernateDao;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateDao h=new HibernateDao();
		List list=new ArrayList();
		
		//list=h.searchPage(1, 15);
		
		for(int i=0;i<list.size();i++){
			User u=new User();
			u=(User) list.get(i);
			System.out.println(u.getName()+" ---  "+u.getAge());
		}
		
		System.out.println(h.SearchPageCount(3));
	}

}
