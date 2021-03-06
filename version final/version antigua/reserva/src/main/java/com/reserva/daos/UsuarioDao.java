package com.reserva.daos;

import java.util.List;

import com.reserva.dtos.UsuarioDto;
import com.reserva.entities.UsuarioEntity;



public interface UsuarioDao{
	
	UsuarioEntity findByNombre(String nombre);
	
	UsuarioDto findByUsuario(String username);
	
	void saveUsuario(UsuarioDto usuarioDto);
	
	List<UsuarioDto> getUsuarios();
	
	void deleteUsuario(String username);

	void borrarUsuario(Long idUsuario);

	List<UsuarioDto> getUsuariosId(Long idl);

	void modificarUsuario(Long idl, String usuario, String apellidos, String email);
}
