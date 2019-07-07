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

@WebServlet("/VisaViewe")
public class VisaViewe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VisaViewe() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Visa visa = new Visa();
		
		HttpSession session = request.getSession(false);
		visa.setUser((String)session.getAttribute("username"));
		
		request.setAttribute("visa", visa);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewapplyvisa.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
