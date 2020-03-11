package com.reserva.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ars_reservas_sal")
public class Ars_reservas_salEntity {
	
	@Id
	@Column(name = "pk_id_sala")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pk_id_sala;
	
	@Column(name = "var_nombre_sala")
	private String var_nombre_sala;
	
	@Column(name = "var_descripcion_sala")
	private String var_descripcion_sala;

	public Long getPk_id_sala() {
		return pk_id_sala;
	}

	public void setPk_id_sala(Long pk_id_sala) {
		this.pk_id_sala = pk_id_sala;
	}

	public String getVar_nombre_sala() {
		return var_nombre_sala;
	}

	public void setVar_nombre_sala(String var_nombre_sala) {
		this.var_nombre_sala = var_nombre_sala;
	}

	public String getVar_descripcion_sala() {
		return var_descripcion_sala;
	}
//descripcion
	public void setVar_descripcion_sala(String var_descripcion_sala) {
		this.var_descripcion_sala = var_descripcion_sala;
	}

	
	
}
