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


@WebServlet("/ExtendPayment")
public class ExtendPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ExtendPayment() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Extend extend = new Extend();

		extend.setId(Integer.parseInt(request.getParameter("id")));
		
		ConfirmExtend exService = new ConfirmExtend();
		exService.checkPayment(extend);
		
		HttpSession session = request.getSession();
		session.setAttribute("id",extend.getId());
		session.setAttribute("country",extend.getCountry());
		session.setAttribute("vtype",extend.getVvtype());
		session.setAttribute("days",extend.getDays());
		session.setAttribute("dcharge",extend.getDcharge());
		session.setAttribute("extday",extend.getExtday());
		session.setAttribute("amount",extend.getCtotal());
		session.setAttribute("total",extend.getTotal());
		
		request.setAttribute("extend", extend);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/extendpayment.jsp");
		dispatcher.forward(request, response);
		
	}

}
