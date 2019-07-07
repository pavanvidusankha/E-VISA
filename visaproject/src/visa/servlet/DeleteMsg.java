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


@WebServlet("/DeleteMsg")
public class DeleteMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteMsg() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		Message msg = new Message();

		msg.setId(Integer.parseInt(request.getParameter("id")));
		
		DeleteMessage dmsg = new DeleteMessage();
		dmsg.deleteMsg(msg);
		
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminviewmsg.jsp");
		dispatcher.forward(request, response);
		
	}

}
