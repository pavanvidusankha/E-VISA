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


@WebServlet("/UpdateExtend")
public class UpdateExtend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateExtend() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Extend extend = new Extend();

		extend.setId(Integer.parseInt(request.getParameter("id")));
		extend.setDays(Integer.parseInt(request.getParameter("days")));
		extend.setExtday(Integer.parseInt(request.getParameter("extday")));
		extend.setCtotal(Double.parseDouble(request.getParameter("total")));
		extend.setEtotal(Double.parseDouble(request.getParameter("amount")));
		
		
		ExtendService addextend = new ExtendService();
		addextend.saveExtend(extend);
		
		request.setAttribute("extend", extend);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paymentsuccess.jsp");
		dispatcher.forward(request, response);
		
	}

}
