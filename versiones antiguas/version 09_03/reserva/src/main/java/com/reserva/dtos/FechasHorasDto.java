package com.reserva.dtos;

import java.sql.Date;
import java.sql.Time;

import com.reserva.entities.SalasEntity;

public class FechasHorasDto {
    private Long idfechahora;
    private Date fecha;
	private Time hora;
	
	private Long sala_id;
	
   

	public Long getSala_id() {
		return sala_id;
	}





	public void setSala_id(Long sala_id) {
		this.sala_id = sala_id;
	}





	public void setIdfechahora(Long idfechahora) {
		this.idfechahora = idfechahora;
	}





	public Long getIdfechahora() {
		return idfechahora;
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
