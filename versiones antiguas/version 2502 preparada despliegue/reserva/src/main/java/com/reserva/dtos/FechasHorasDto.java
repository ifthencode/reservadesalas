package com.reserva.dtos;

import java.sql.Date;
import java.sql.Time;

public class FechasHorasDto {
    private Long idfechahora;
    private Date fecha;
	private Time hora;

   
	



	public Long getIdfechahora() {
		return idfechahora;
	}



	public void setIdfechahora(long idfechahora) {
		this.idfechahora = idfechahora;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public Time getHora() {
		return hora;
	}



	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	
	
	
	
	
	
	

	
	

}
