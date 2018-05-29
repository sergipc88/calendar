package com.addapta.calendar.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.addapta.calendar.getway.dto.DtoCita;
import com.addapta.calendar.persistence.entity.Cita;

public class CitasUtilities {

	public static List<DtoCita> putOnDtoCita(List<Cita> lista) {
		
		Cita cita;
		DtoCita cp;
		List<DtoCita>listaCitas = new ArrayList<>();
		Iterator it = lista.iterator();
				
			while(it.hasNext()){
			
				cita = new Cita();
				cp = new DtoCita();
			
				cita =(Cita) it.next();
			
				cp.setId(cita.getId()+"");
				cp.setResourceid(cita.getC().getId()+"");
				cp.setStart(DateUtilities.joinDH(cita.getFechaInicio(), cita.getHoraInit()));
				cp.setEnd(DateUtilities.joinDH(cita.getFechaFin(), cita.getHoraFin()));
				cp.setTitle(cita.getDescripcion());
				cp.setColor(cita.getC().getColor());
			
				listaCitas.add(cp);
			}
		return listaCitas;	
	}
}
