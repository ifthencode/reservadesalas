package com.reserva.dtos;

public class ReservasDto {

	private Long idreserva;
	private SalasDto salas_id;
	private UsuarioDto usuarios;
	private FechasHorasDto fechashoras_id;
	private String comentarios;
	public Long getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(Long idreserva) {
		this.idreserva = idreserva;
	}
	public SalasDto getSalas() {
		return salas_id;
	}
	public void setSalas(SalasDto salas) {
		this.salas_id = salas;
	}
	public UsuarioDto getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(UsuarioDto usuarios) {
		this.usuarios = usuarios;
	}
	public FechasHorasDto getFechashoras() {
		return fechashoras_id;
	}
	public void setFechashoras(FechasHorasDto fechashoras) {
		this.fechashoras_id = fechashoras;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
}
