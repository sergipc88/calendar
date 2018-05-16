package com.addapta.calendar.business.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addapta.calendar.persistence.UserBO.UserBO;
import com.addapta.calendar.persistence.entity.User;
import com.addapta.utilities.security.Security;

/**
 * Servlet implementation class controlador
 */
@WebServlet("/controlador")
public class controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "main.jsp";
		User user = new User();
		UserBO uBO = new UserBO();	
		
		String nombreUser= request.getParameter("user");
		String correo = request.getParameter("mail");
		String passd = request.getParameter("pass");
		String repassd = request.getParameter("repitPass");
		
		boolean userRep = Security.userExist(nombreUser);//compruebo si existe el user
		boolean mailRep = Security.mailExist(correo);//compruebo si exista el mail
		boolean passNoCoincidens = Security.passComprovation(passd, repassd);//compruebo si el pass coincide con el 
																			//campo "introduce de nuevo la contraseña"
		
		if(userRep||mailRep||passNoCoincidens) {
			
			request.setAttribute("error", "hay algun error en los datos introducidos");
			pagina = "registro.jsp";
			request.getRequestDispatcher(pagina).forward(request, response);
			
		}else {
			
			user.setUsuario(nombreUser.trim());
			user.setMail(correo.trim());
			user.setPass(Security.encrypt(passd.trim()));//introduzco en el usuario 
														//la contraseña a la vez que la encripto
			
			user = uBO.alta(user);
			request.setAttribute("usuario", user);
			request.getRequestDispatcher(pagina).forward(request, response);
		}
		
		
		
		
		
		
		
		
		

		
							
//		user.setUsuario("pedro");
//		user.setPass(Security.encrypt(passd));
//		user.setMail("pedro@mail.com");
//		
//		
//		uBO.alta(user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
