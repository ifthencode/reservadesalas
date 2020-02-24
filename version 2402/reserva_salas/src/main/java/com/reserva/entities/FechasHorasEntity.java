package com.reserva.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fechashoras")
public class FechasHorasEntity  {
	
	
	  
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idfechahora")
	private Long idreserva;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "hora")
	private Time hora;
	
	@Column(name = "disponible")
	private Boolean disponible;
    
	

	
	
	
	

	public Long getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(Long idreserva) {
		this.idreserva = idreserva;
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

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}


	
    
	

	
		
}
