package com.addapta.calendar.business.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.addapta.calendar.persistence.UserBO.UserBO;
import com.addapta.calendar.persistence.entity.User;
import com.addapta.utilities.security.Security;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "main.jsp";
		User u = new User();
		UserBO uBO = new UserBO();
		HttpSession session = request.getSession();
		
		String nombreUser= request.getParameter("user");
		String passd = request.getParameter("pass");
		
		
		
		boolean validUser = Security.userValidation(nombreUser.trim(), Security.encrypt(passd.trim()));//compruebo si el user existe en la bbdd
		//el metodo userValidation me devuelve true si el usuario existe y false sino.
		
		
		if(validUser) {
			u.setUsuario(nombreUser.trim()); //itroduzco el nombre de usuario en el Objeto usuario
			u.setPass(Security.encrypt(passd.trim()));//itroduzco la contraseña de usuario en el Objeto usuario a la vez que se encripta
			u = uBO.recuperarUserValidado(u);
			
			
			
			request.setAttribute("usuario", u);
			 session.setAttribute("user", u);
			request.getRequestDispatcher(pagina).forward(request, response);
			
			
		}else {
			
			pagina = "login.jsp";
			request.setAttribute("error", "hay algun error en los datos introducidosel usuario no existe");
			request.getRequestDispatcher(pagina).forward(request, response);
			
		}
		
					
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
