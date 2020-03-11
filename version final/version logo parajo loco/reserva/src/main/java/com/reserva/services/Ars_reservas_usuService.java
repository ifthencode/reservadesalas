package com.reserva.services;

import java.util.List;

import com.reserva.dtos.Ars_reservas_usuDto;



public interface Ars_reservas_usuService {

	Ars_reservas_usuDto findByName(String nombre);
	void saveUsuario(Ars_reservas_usuDto usuarioDto);
	void borrarUsuario(Long idUsuario);
	List<Ars_reservas_usuDto> getUsuarioId(Long idl);
	void modificarUsuario(Long idl, String usuario, String apellidos, String email);
}
