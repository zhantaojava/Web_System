package model;

public class UserBeanProcess {
	public boolean CheckUser(String username,String password){
		boolean b=false;
		
		if(username.equals("szt")&&password.equals("123")){
			b=true;
		}
		
		return b;
		
		
	}
}
