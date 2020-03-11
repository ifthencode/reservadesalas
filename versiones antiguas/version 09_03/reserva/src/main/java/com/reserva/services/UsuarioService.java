package com.reserva.services;

import java.util.List;

import com.reserva.dtos.UsuarioDto;

public interface UsuarioService {

	UsuarioDto findByName(String nombre);
	void saveUsuario(UsuarioDto usuarioDto);
	void borrarUsuario(Long idUsuario);
	List<UsuarioDto> getUsuarioId(Long idl);
	void modificarUsuario(Long idl, String usuario, String apellidos, String email);
}
