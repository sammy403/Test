package service;

import bean.User;
import dao.LoginDao;

public class LoginService {
	
	public User login(String u,String p)
	{
		LoginDao ld= new LoginDao();
		return ld.login(u, p);
		
	}

}
