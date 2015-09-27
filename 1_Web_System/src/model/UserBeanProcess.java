package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dao.HibernateDao;
/**
 * Function same as Service Layer
 * @author suzhantao
 *
 */
@Component
public class UserBeanProcess {
	
	@Autowired
	private HibernateDao hibernateDao;
	
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
	
	public boolean AddUser(String username,String password,int age){
		boolean statue=false;
		
		
		//determine if the user existing 
		List<User> list = new LinkedList<User>();
		list=hibernateDao.searchUser(username);
		
		User user=new User();
		user.setName(username);
		
		boolean userExisting=list.contains(user);
		
		Date date=new Date();
		
		//if user not existing ,execute saving
		if(userExisting==false){
			user.setAge(age);
			user.setPw(password);
			user.setDate(date);
			
			Object object=hibernateDao.save(user);
			statue=true;
			return statue;
		}
		else{
			return statue;
		}
		
		
	}

		
	
}
