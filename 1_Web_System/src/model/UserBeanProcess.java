package model;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import dao.HibernateDao;

public class UserBeanProcess {
	private HibernateDao hibernateDao=new HibernateDao();
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean ValidateUser(String username,String password){
		boolean b = false;

		List<User> list = new LinkedList<User>();

		list = hibernateDao.searchUser(username);

		User user = new User();

		if (!list.isEmpty()) {
			user = list.get(0);
			if (user.getPw().equals(password)) {
				b = true;
				return b;
			}
		}

		return b;
	}
}
