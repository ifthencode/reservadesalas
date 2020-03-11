package com.reserva.dtos;

public class ReservasDto {

	private Long idreserva;
	private SalasDto salas;
	private UsuarioDto usuarios;
	private FechasHorasDto fechashoras;
	private String comentarios;
	public Long getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(Long idreserva) {
		this.idreserva = idreserva;
	}
	public SalasDto getSalas() {
		return salas;
	}
	public void setSalas(SalasDto salas) {
		this.salas = salas;
	}
	public UsuarioDto getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(UsuarioDto usuarios) {
		this.usuarios = usuarios;
	}
	public FechasHorasDto getFechashoras() {
		return fechashoras;
	}
	public void setFechashoras(FechasHorasDto fechashoras) {
		this.fechashoras = fechashoras;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
}
