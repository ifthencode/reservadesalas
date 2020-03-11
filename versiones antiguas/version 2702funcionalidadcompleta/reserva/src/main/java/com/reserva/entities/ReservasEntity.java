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
@Table(name="reservas")
public class ReservasEntity  {
	
	
	  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idreserva")
	private Long idreserva;
	
	
	@OneToOne
    @JoinColumn(name = "sala_id")
	private SalasEntity sala_id;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuario_id;
	
	@OneToOne
	@JoinColumn(name = "fechahora_id")
	private FechasHorasEntity fechahora_id;
	
	/*
	 * @OneToOne( orphanRemoval = true,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "sala_id") private SalasEntity sala_id;
	 * 
	 * @OneToOne( orphanRemoval = true,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "usuario_id") private UsuarioEntity usuario_id;
	 * 
	 * @OneToOne( orphanRemoval = true,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "fechahora_id") private FechasHorasEntity fechahora_id;
	 */
	
	
	@Column(name = "comentarios")
	private String comentarios;


	public Long getIdreserva() {
		return idreserva;
	}


	public void setIdreserva(Long idreserva) {
		this.idreserva = idreserva;
	}


	/*
	 * public SalasEntity getSala_id() { return sala_id; }
	 * 
	 * 
	 * public void setSala_id(SalasEntity sala_id) { this.sala_id = sala_id; }
	 * 
	 * 
	 * public UsuarioEntity getUsuario_id() { return usuario_id; }
	 * 
	 * 
	 * public void setUsuario_id(UsuarioEntity usuario_id) { this.usuario_id =
	 * usuario_id; }
	 * 
	 * 
	 * public FechasHorasEntity getFechahora_id() { return fechahora_id; }
	 * 
	 * 
	 * public void setFechahora_id(FechasHorasEntity fechahora_id) {
	 * this.fechahora_id = fechahora_id; }
	 */
    

	public String getComentarios() {
		return comentarios;
	}


	public SalasEntity getSala_id() {
		return sala_id;
	}


	public void setSala_id(SalasEntity sala_id) {
		this.sala_id = sala_id;
	}


	public UsuarioEntity getUsuario_id() {
		return usuario_id;
	}


	public void setUsuario_id(UsuarioEntity usuario_id) {
		this.usuario_id = usuario_id;
	}


	public FechasHorasEntity getFechahora_id() {
		return fechahora_id;
	}


	public void setFechahora_id(FechasHorasEntity fechahora_id) {
		this.fechahora_id = fechahora_id;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
    
	

	
		
}
