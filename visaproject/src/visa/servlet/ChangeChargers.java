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


@WebServlet("/ChangeChargers")
public class ChangeChargers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ChangeChargers() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Payment payment = new Payment();

		payment.setCid(Integer.parseInt(request.getParameter("cid")));
		payment.setScharge(Double.parseDouble(request.getParameter("scharge")));
		payment.setDcharge(Double.parseDouble(request.getParameter("dcharge")));
		
		ChargersChange charge = new ChargersChange();
		charge.change(payment);
		
		request.setAttribute("payment", payment);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminchargers.jsp");
		dispatcher.forward(request, response);
		
	}

}
