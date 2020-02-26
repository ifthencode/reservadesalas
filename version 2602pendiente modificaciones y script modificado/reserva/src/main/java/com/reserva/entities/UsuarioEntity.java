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
@Table(name="usuarios")
public class UsuarioEntity  {
	
	
	  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idusuario")
	private Long idusuario;
	/*
	 * @Column(name = "usuario") private String usuario;
	 * 
	 * @Column(name = "password") private String password;
	 */
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	/*
	 * @Column(name = "apellido2") private String apellido2;
	 */
	
	@Column(name = "email")
	private String email;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="rol_id") private SalasEntity rol;
	 */
	
	public Long getIdUsuario() {
		return idusuario;
	}

	/*
	 * public void setIdUsuario(Long id) { this.idusuario = id; }
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * public String getApellido1() { return apellido1; }
	 */

	/*
	 * public void setApellido1(String apellido1) { this.apellido1 = apellido1; }
	 */

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * public SalasEntity getRol() { return rol; }
	 * 
	 * public void setRol(SalasEntity rol) { this.rol = rol; }
	 * 
	 * public String getUsuario() { return usuario; }
	 * 
	 * public void setUsuario(String usuario) { this.usuario = usuario; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */
		
}
