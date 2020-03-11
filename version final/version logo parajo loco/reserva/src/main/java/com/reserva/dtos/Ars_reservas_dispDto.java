package com.reserva.dtos;

import java.sql.Date;
import java.sql.Time;



public class Ars_reservas_dispDto {
    private Long pk_id_disponibilidad;
    private Date date_fecha_disponibilidad;
	private Time time_hora_disponibilidad;
	private String var_disponible;
	private Long fk_id_sala;
	
   

	public Long getFk_id_sala() {
		return fk_id_sala;
	}


	public void setFk_id_sala(Long fk_id_sala) {
		this.fk_id_sala = fk_id_sala;
	}

	public void setPk_id_disponibilidad(Long pk_id_disponibilidad) {
		this.pk_id_disponibilidad = pk_id_disponibilidad;
	}


	public Long getPk_id_disponibilidad() {
		return pk_id_disponibilidad;
	}




	public Date getDate_fecha_disponibilidad() {
		return date_fecha_disponibilidad;
	}



	public void setDate_fecha_disponibilidad(Date date_fecha_disponibilidad) {
		this.date_fecha_disponibilidad = date_fecha_disponibilidad;
	}



	public Time getTime_hora_disponibilidad() {
		return time_hora_disponibilidad;
	}



	public void setTime_hora_disponibilidad(Time time_hora_disponibilidad) {
		this.time_hora_disponibilidad = time_hora_disponibilidad;
	}





	public String getVar_disponible() {
		return var_disponible;
	}





	public void setVar_disponible(String var_disponible) {
		this.var_disponible = var_disponible;
	}





	
	
	
	
	
	
	
	
	

	
	

}
