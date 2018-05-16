package com.addapta.calendar.business.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addapta.calendar.getway.dto.DtoNombrerepetido;
import com.addapta.calendar.persistence.UserBO.UserBO;
import com.addapta.calendar.persistence.entity.User;
import com.addapta.calendar.utilities.json.JsonUtilities;
import com.google.gson.Gson;

/**
 * Servlet implementation class nombrerepetido
 */
@WebServlet("/nombreRepetido")
public class NombreRepetido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NombreRepetido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u = new User();
		UserBO uBO = new UserBO();
		DtoNombrerepetido dto = new DtoNombrerepetido();		
		String nombre = request.getParameter("user");
					
		if(nombre != null && nombre.trim().length() != 0) {
			dto.setSuccess(true);
			u.setUsuario(nombre);
			dto.setRepeated(uBO.recoveryUser(u));
		} else {
			dto.setSuccess(true);
			dto.setRepeated(false);
		}
		
	
		
		String json = JsonUtilities.jsonConverter(dto);
		  
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
