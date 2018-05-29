package com.addapta.calendar.business.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addapta.calendar.persistence.BO.CalendarioBO;
import com.addapta.calendar.persistence.entity.Calendario;
import com.addapta.calendar.persistence.entity.Cita;
import com.addapta.calendar.utilities.DateUtilities;

/**
 * Servlet implementation class calendarios
 */
@WebServlet("/calendarios")
public class calendarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calendarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cita c = new Cita();
		Calendario ca = new Calendario();
		CalendarioBO caBO = new CalendarioBO();
		
		String nombre= "negocios";
		String color = "blue";
		String descripcion ="bussines calendar";
		
		String descripcionCita ="he quedado con Lucas";
		Date dateInit = DateUtilities.dateParser("2018-05-19");
		Date dateFin = DateUtilities.dateParser("2018-05-22");
		Date hInit = DateUtilities.hourParser("13:30:00");
		Date hFin = DateUtilities.hourParser("20:12:01");
		
		c.setDescripcion(descripcionCita);
		c.setFechaInicio(dateInit);
		c.setHoraInit(hInit);
		c.setFechaFin(dateFin);
		c.setHoraFin(hFin);
		
		ca.setNombre(nombre);
		ca.setColor(color);
		ca.setDescripcion(descripcion);
		
		
		caBO.create(ca);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
