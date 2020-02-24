package com.reserva.dtos;

public class UsuarioDto {
    private long idusuario;
	private String nombre;
	
	
	
	private String apellidos;
	
	
	
	private String email;
	
	
	
	public String getNombre() {
		return nombre;
	}

	public long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(long idusuario) {
		this.idusuario = idusuario;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	 public String getApellidos() { return apellidos; }
	 
	 public void setApellidos(String apellidos) { 
		 this.apellidos = apellidos; }
	 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

}
