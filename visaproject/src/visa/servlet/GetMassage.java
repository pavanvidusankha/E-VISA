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


@WebServlet("/GetMassage")
public class GetMassage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetMassage() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Message msg = new Message();

		msg.setName(request.getParameter("name"));
		msg.setMail(request.getParameter("mail"));
		msg.setMsg(request.getParameter("msg"));
		
		SendMessage msgs = new SendMessage();
		msgs.sendMsg(msg);
		
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/sendmassage.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
