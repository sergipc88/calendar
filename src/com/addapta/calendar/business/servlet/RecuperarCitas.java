package com.addapta.calendar.business.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addapta.calendar.getway.dto.DtoCita;
import com.addapta.calendar.persistence.BO.CitaBO;
import com.addapta.calendar.persistence.entity.Cita;
import com.addapta.calendar.utilities.CitasUtilities;
import com.addapta.calendar.utilities.DateUtilities;
import com.addapta.calendar.utilities.JsonUtilities;

/**
 * Servlet implementation class recuperarcitas
 */
@WebServlet("/recuperarcitas")
public class RecuperarCitas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarCitas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String init = request.getParameter("start");
		String fin = request.getParameter("end");
		
		Date start = DateUtilities.dateParser(init);
		Date end = DateUtilities.dateParser(fin);
		
		CitaBO cBO = new CitaBO();
		
		List<Cita> citas = cBO.selectByDate(start, end);
		
		List<DtoCita>preparedDates = CitasUtilities.putOnDtoCita(citas);
		
		
		
		String listaCitas = JsonUtilities.jsonConverter(preparedDates);
		
		System.out.println(listaCitas);
		
		response.getWriter().print(listaCitas);
		
		//request.setAttribute("event", listaCitas);
		//request.getRequestDispatcher("calendar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
