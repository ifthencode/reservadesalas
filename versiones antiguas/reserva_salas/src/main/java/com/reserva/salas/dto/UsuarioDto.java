package com.reserva.salas.dto;

public class UsuarioDto {
    private long idusuario;
	private String nombre;
	
	//private String password;
	
	//private String usuario;
	
	private String apellidos;
	
	//private String apellido2;
	
	private String email;
	
	//private SalasDto rol;
	
	
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

	/*
	 * public String getApellido1() { return apellido1; }
	 * 
	 * public void setApellido1(String apellido1) { this.apellido1 = apellido1; }
	 * 
	 */ 
	 public String getApellidos() { return apellidos; }
	 
	 public void setApellidos(String apellidos) { 
		 this.apellidos = apellidos; }
	 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * public SalasDto getRol() { return rol; }
	 * 
	 * public void setRol(SalasDto rol) { this.rol = rol; }
	 */
	/*
	 * public String getUsuario() { return usuario; }
	 * 
	 * public void setUsuario(String usuario) { this.usuario = usuario; }
	 */

	/*
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */
	
	

}
