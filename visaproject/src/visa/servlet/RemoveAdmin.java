package visa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visa.model.User;
import visa.service.*;


@WebServlet("/RemoveAdmin")
public class RemoveAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RemoveAdmin() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		User user = new User();

		user.setId(Integer.parseInt(request.getParameter("id")));
		
		AdminToUser auser = new AdminToUser();
		auser.createUser(user);
		
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminremove.jsp");
		dispatcher.forward(request, response);
		
	}

}
