package com.reserva.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ars_reservas")
public class Ars_reservasEntity  {
	
	
	  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_id_reserva")
	private Long pk_id_reserva;
	
	
	@OneToOne
    @JoinColumn(name = "fk_id_sala")
	private Ars_reservas_salEntity fk_id_sala;
	
	@OneToOne
	@JoinColumn(name = "fk_id_usuario")
	private Ars_reservas_usuEntity fk_id_usuario;
	
	
	  @OneToOne
	  
	  @JoinColumn(name = "fk_id_disponibilidad")
	  private Ars_reservas_dispEntity fk_id_disponibilidad;
	 
	
	
	
	
	@Column(name = "var_comentarios")
	private String var_comentarios;


	public Long getPk_id_reserva() {
		return pk_id_reserva;
	}


	public void setPk_id_reserva(Long pk_id_reserva) {
		this.pk_id_reserva = pk_id_reserva;
	}


    

	public String getVar_comentarios() {
		return var_comentarios;
	}


	public Ars_reservas_salEntity getFk_id_sala() {
		return fk_id_sala;
	}


	public void setFk_id_sala(Ars_reservas_salEntity fk_id_sala) {
		this.fk_id_sala = fk_id_sala;
	}


	public Ars_reservas_usuEntity getUsuario_id() {
		return fk_id_usuario;
	}


	public void setUsuario_id(Ars_reservas_usuEntity fk_id_usuario) {
		this.fk_id_usuario = fk_id_usuario;
	}


	
	  public Ars_reservas_dispEntity getPk_id_disponibilidad() { return fk_id_disponibilidad; }
	  
	  
	  public void setFk_id_disponibilidad(Ars_reservas_dispEntity fk_id_disponibilidad) {
	  this.fk_id_disponibilidad = fk_id_disponibilidad; }
	 


	public void setVar_comentarios(String var_comentarios) {
		this.var_comentarios = var_comentarios;
	}
	
    
	

	
		
}
