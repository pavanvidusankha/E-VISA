package visa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import visa.model.Payment;
import visa.service.*;

@WebServlet("/Calculate")
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Calculate() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Payment payment = new Payment();

		payment.setDays(Integer.parseInt(request.getParameter("days")));
		payment.setVtype(Integer.parseInt(request.getParameter("vtype")));
		
		CalculateCharge calService = new CalculateCharge();
		calService.calPayment(payment);
		
		HttpSession session = request.getSession();
		session.setAttribute("calculatetotal",payment.getTotal());
		
		
		request.setAttribute("payment", payment);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/calculate.jsp");
		dispatcher.forward(request, response);
		
	}

}
