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


@WebServlet("/ApplyVisa")
public class ApplyVisa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ApplyVisa() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Visa visa = new Visa();

		visa.setFname(request.getParameter("fname"));
		visa.setLname(request.getParameter("lname"));
		visa.setSname(request.getParameter("sname"));
		visa.setBday(request.getParameter("bday"));
		visa.setGender(request.getParameter("gender"));
		visa.setMail(request.getParameter("mail"));
		visa.setPnumber(Integer.parseInt(request.getParameter("pnumber")));
		visa.setCountry(request.getParameter("country"));
		visa.setVtype(Integer.parseInt(request.getParameter("vtype")));
		visa.setIday(request.getParameter("iday"));
		visa.setDays(Integer.parseInt(request.getParameter("days")));
		visa.setPid(Integer.parseInt(request.getParameter("pid")));
		visa.setUser(request.getParameter("user"));
		
		VisaService applyVisa = new VisaService();
		applyVisa.applyVisa(visa);
		
		request.setAttribute("visa", visa);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/applysuccess.jsp");
		dispatcher.forward(request, response);
		
	}

}
