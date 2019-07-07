package visa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import visa.model.User;
import visa.model.Visa;
import visa.service.*;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		User user = new User();

		//user.setId(Integer.parseInt(request.getParameter("studentId")));
		user.setName(request.getParameter("name"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("pwd1"));
		
		UserService userService = new UserService();
		userService.addUser(user);
		
		if(userService.getAlreadyUser()==0) {
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/regsucces.jsp");
			dispatcher.forward(request, response);
		}else{
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/alreadyuser.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
