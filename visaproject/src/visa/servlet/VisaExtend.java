package visa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visa.model.*;
import visa.service.*;


@WebServlet("/VisaExtend")
public class VisaExtend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VisaExtend() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Extend extend = new Extend();

		extend.setId(Integer.parseInt(request.getParameter("id")));
		extend.setExtday(Integer.parseInt(request.getParameter("days")));
		
		ApplyExtend extendvisa = new ApplyExtend();
		extendvisa.extend(extend);
		
		request.setAttribute("extend", extend);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/successextend.jsp");
		dispatcher.forward(request, response);
		
	}

}
