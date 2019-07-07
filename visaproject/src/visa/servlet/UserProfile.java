package visa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import visa.model.*;
import visa.service.*;


@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserProfile() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Profile pro = new Profile();
		
		pro.setUsername(request.getParameter("username"));
		pro.setPassword(request.getParameter("password"));
		
		UpdateUser userService = new UpdateUser();
		userService.updateUser(pro);
		
		request.setAttribute("pro", pro);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updatesuccessfully.jsp");
		dispatcher.forward(request, response);
		
	}

}
