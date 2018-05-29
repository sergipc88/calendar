package com.addapta.calendar.business.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addapta.calendar.persistence.BO.CitaBO;
import com.addapta.calendar.persistence.entity.Calendario;
import com.addapta.calendar.persistence.entity.Cita;
import com.addapta.calendar.utilities.DateUtilities;

/**
 * Servlet implementation class calendar
 */
@WebServlet("/citas")
public class citas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public citas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cita c = new Cita();
		Calendario ca = new Calendario();
		CitaBO cBO = new CitaBO();
		String action = request.getParameter("action");
		String descripcion =request.getParameter("description");
		String fechaInitio = request.getParameter("fInit");
		String fechaFin = request.getParameter("fFin");
		String h_init= request.getParameter("hInit");
		String h_fin = request.getParameter("hFin");
		String idString = request.getParameter("id");
		int idCalendar = Integer.parseInt(request.getParameter("idcal"));

		if(action.equals("alta")|| action.equals("update")) {		
	
			Date dateInit = DateUtilities.dateParser(fechaInitio);
			Date dateFin = DateUtilities.dateParser(fechaFin);
			Date hInit = DateUtilities.hourParser(h_init);
			Date hFin = DateUtilities.hourParser(h_fin);	
				
			c.setDescripcion(descripcion);
			c.setFechaInicio(dateInit);
			c.setFechaFin(dateFin);
			c.setHoraInit(hInit);
			c.setHoraFin(hFin);
			ca.setId(idCalendar);
			c.setC(ca);
			
			if(action.equals("alta")) {
				cBO.create(c);
				
				request.getRequestDispatcher("recuperarCalendario").forward(request, response);
			}else {
				int id = Integer.parseInt(idString);
				c.setId(id);
				cBO.update(c);
			}
		
			
		}else if(action.equals("baja")) {
			int id = Integer.parseInt(idString);
			c.setId(id);
			cBO.delete(c);			
			
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
