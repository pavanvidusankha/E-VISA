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


@WebServlet("/AddPayment")
public class AddPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Payment Payment = new Payment();

		Payment.setId(Integer.parseInt(request.getParameter("id")));
		Payment.setCid(Integer.parseInt(request.getParameter("cid")));
		Payment.setUser(request.getParameter("user"));
		Payment.setCountry(request.getParameter("country"));
		Payment.setVtype(Integer.parseInt(request.getParameter("vtype")));
		Payment.setDays(Integer.parseInt(request.getParameter("days")));
		Payment.setCtotal(Double.parseDouble(request.getParameter("total")));
		
		
		PaymentService addpayment = new PaymentService();
		addpayment.savePayment(Payment);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paymentsuccess.jsp");
		dispatcher.forward(request, response);
		
	}

}
