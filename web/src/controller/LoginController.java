package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;

import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("login")){
		User user=new User();
		String userid=request.getParameter("username");
		String password=request.getParameter("password");
		LoginService ls= new LoginService();
		user=ls.login(userid, password);
		if(user!=null)
		{
			if(user.getStatus().equalsIgnoreCase("active"))
			{
			request.setAttribute("user", user);
			RequestDispatcher rd=request.getRequestDispatcher("sucess.jsp");
			rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("inactive.jsp");
				rd.forward(request, response);
			}
				
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("invalid.jsp");
			rd.forward(request, response);
		}
		}
		else if(action.equals("home"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
	}
		
		
		
		
		
	}


