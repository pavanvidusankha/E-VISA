package visa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import visa.model.*;
import visa.service.*;
import javax.*;
import java.util.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*PrintWriter out = response.getWriter();*/
		
		response.setContentType("text/html");
		
		Login login = new Login();

		login.setUsername(request.getParameter("username"));
		login.setPassword(request.getParameter("password"));
		
		LoginService loginService = new LoginService();
		loginService.checkLogin(login);
		
		if(loginService.getPassUser()==1) {
			request.setAttribute("login", login);
			HttpSession session = request.getSession();
			session.setAttribute("username",login.getUsername());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
			dispatcher.forward(request, response);
		}else if(loginService.getPassUser()==2) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username",login.getUsername());
			response.sendRedirect("welcome.jsp");
			
		}else if(loginService.getPassUser()==3) {
			request.setAttribute("login", login);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/incorrectuser.jsp");
			dispatcher.forward(request, response);
		}	
			
		
		
	}

}
