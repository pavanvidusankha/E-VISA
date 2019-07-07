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


@WebServlet("/AdminAction")
public class AdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminAction() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Action action = new Action();

		action.setId(Integer.parseInt(request.getParameter("id")));
		action.setAction(Integer.parseInt(request.getParameter("action")));
		
		if(action.getAction()==1){
			
			Passport passport = new Passport();
			
			passport.setId(action.getId());
			
			CheckPassport passportService = new CheckPassport();
			passportService.checkPassport(passport);
			
			if(passport.getPassportid()==0) {
			
				HttpSession session = request.getSession();
				session.setAttribute("id",passport.getId());
				session.setAttribute("fname","-----");
				session.setAttribute("lname","-----");
				session.setAttribute("passportid","-----");
				session.setAttribute("pfname","-----");
				session.setAttribute("plname","-----");
				session.setAttribute("Idate","-----");
				session.setAttribute("Exdate","-----");
				session.setAttribute("passport","User's Given Passport ID Doesn't Exists");
			
			}else {
				
				HttpSession session = request.getSession();
				session.setAttribute("id",passport.getId());
				session.setAttribute("fname",passport.getFname());
				session.setAttribute("lname",passport.getLname());
				session.setAttribute("passportid",passport.getPassportid());
				session.setAttribute("pfname",passport.getPfname());
				session.setAttribute("plname",passport.getPlname());
				session.setAttribute("Idate",passport.getIdate());
				session.setAttribute("Exdate",passport.getExdate());
				
			}
			
			request.setAttribute("passport", passport);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminverifyapply.jsp");
			dispatcher.forward(request, response);
			
		}else {
		
		ActionService newaction = new ActionService();
		newaction.checkAction(action);
		
		request.setAttribute("action", action);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminsuccessfull.jsp");
		dispatcher.forward(request, response);
		
		}	
	}

}
