package com.reserva.salas.dao;

import java.util.List;

import com.reserva.salas.dto.UsuarioDto;
import com.reserva.salas.entity.UsuarioEntity;



public interface UsuarioDao{
	
	UsuarioEntity findByNombre(String nombre);
	
	UsuarioDto findByUsuario(String username);
	
	void saveUsuario(UsuarioDto usuarioDto);
	
	List<UsuarioDto> getUsuarios();
	
	void deleteUsuario(String username);
}
