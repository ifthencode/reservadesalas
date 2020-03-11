package com.reserva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ars_reservas_usu")
public class Ars_reservas_usuEntity  {
	
	
	  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_id_usuario")
	private Long pk_id_usuario;
	
	@Column(name = "var_nombre_usuario")
	private String var_nombre_usuario;
	
	@Column(name = "var_apellidos_usuario")
	private String var_apellidos_usuario;
	
	
	@Column(name = "var_email_usuario")
	private String var_email_usuario;
	
	
	
  
	public Long getPk_id_usuario() {
		return pk_id_usuario;
	}

	public void setPk_id_usuario(Long pk_id_usuario) {
		this.pk_id_usuario = pk_id_usuario;
	}

	
	public String getVar_nombre_usuario() {
		return var_nombre_usuario;
	}

	public void setVar_nombre_usuario(String var_nombre_usuario) {
		this.var_nombre_usuario = var_nombre_usuario;
	}

	

	public String getVar_apellidos_usuario() {
		return var_apellidos_usuario;
	}

	public void setVar_apellidos_usuario(String var_apellidos_usuario) {
		this.var_apellidos_usuario = var_apellidos_usuario;
	}

	public String getVar_email_usuario() {
		return var_email_usuario;
	}

	public void setVar_email_usuario(String var_email_usuario) {
		this.var_email_usuario = var_email_usuario;
	}

	
		
}
