package com.addapta.calendar.business.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addapta.calendar.getway.dto.DtoMailVerification;
import com.addapta.calendar.persistence.BO.UserBO;
import com.addapta.calendar.persistence.entity.User;
import com.addapta.calendar.utilities.JsonUtilities;
import com.addapta.calendar.utilities.Security;

/**
 * Servlet implementation class MailComprovation
 */
@WebServlet("/mailComprovation")
public class MailComprovation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailComprovation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u = new User();
		UserBO uBO = new UserBO();
		String correo = request.getParameter("mail");
		DtoMailVerification dmv = new DtoMailVerification();
		
		if(correo != null && correo.trim().length() != 0) {
			
			dmv.setSuccess(true);
			
			if(Security.isValidEmailAddress(correo)) {
				dmv.setWrongFormat(false);
				u.setMail(correo);
				dmv.setRepeated(uBO.recoveryMail(u));
			}else {
				dmv.setWrongFormat(true);
			}
			
			
			
		} else {
			
			dmv.setSuccess(true);
			dmv.setRepeated(false);
		}
		
		String json = JsonUtilities.jsonConverter(dmv);
		  
		response.getWriter().print(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
