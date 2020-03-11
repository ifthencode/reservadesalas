package com.reserva.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="ars_reservas_disp")
public class Ars_reservas_dispEntity  {
	
	
	  
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_id_disponibilidad")
	private Long pk_id_disponibilidad;
	
	@Column(name = "date_fecha_disponibilidad")
	private Date date_fecha_disponibilidad;
	
	@Column(name = "time_hora_disponibilidad")
	private Time time_hora_disponibilidad;
	
	@Column(name = "var_disponible")
	private String var_disponible;
	
	@ManyToOne
    @JoinColumn(name = "fk_id_sala")
	private Ars_reservas_salEntity fk_id_sala;

	
	
	public Ars_reservas_salEntity getFk_id_sala_id() {
		return fk_id_sala;
	}

	public void setFk_id_sala(Ars_reservas_salEntity fk_id_sala) {
		this.fk_id_sala = fk_id_sala;
	}

	public Long getPk_id_disponibilidad() {
		return pk_id_disponibilidad;
	}

	public void setPk_id_disponibilidad(Long pk_id_disponibilidad) {
		this.pk_id_disponibilidad = pk_id_disponibilidad;
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
