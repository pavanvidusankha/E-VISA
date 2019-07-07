package visa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visa.model.Action;
import visa.service.*;


@WebServlet("/AdminConfirmExtend")
public class AdminConfirmExtend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminConfirmExtend() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Action action = new Action();

		action.setId(Integer.parseInt(request.getParameter("id")));
		action.setAction(Integer.parseInt(request.getParameter("action")));
		
		ExtendAction newaction = new ExtendAction();
		newaction.checkAction(action);
		
		request.setAttribute("action", action);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminsuccessfull.jsp");
		dispatcher.forward(request, response);
		
	}

}
