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


@WebServlet("/VisaPayment")
public class VisaPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VisaPayment() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Payment payment = new Payment();

		payment.setId(Integer.parseInt(request.getParameter("id")));
		
		ConfirmPayments paymentService = new ConfirmPayments();
		paymentService.checkPayment(payment);
		
		HttpSession session = request.getSession();
		session.setAttribute("id",payment.getId());
		session.setAttribute("country",payment.getCountry());
		session.setAttribute("vtype",payment.getVvtype());
		session.setAttribute("days",payment.getDays());
		session.setAttribute("scharge",payment.getScharge());
		session.setAttribute("dcharge",payment.getDcharge());
		session.setAttribute("total",payment.getTotal());
		session.setAttribute("cid",payment.getCid());
		session.setAttribute("vvtype",payment.getVtype());
		
		request.setAttribute("payment", payment);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/confirm&pay.jsp");
		dispatcher.forward(request, response);
		//paymentService.checkLogin(login);
		
	}

}
