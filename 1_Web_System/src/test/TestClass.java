package test;

import java.util.ArrayList;
import java.util.List;

import dao.HibernateDao;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateDao h=new HibernateDao();
		List list=new ArrayList();
		list=h.searchUser("1");
		
	}

}
