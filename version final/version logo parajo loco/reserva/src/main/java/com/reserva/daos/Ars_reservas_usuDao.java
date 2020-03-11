package com.reserva.daos;

import java.util.List;

import com.reserva.dtos.Ars_reservas_usuDto;
import com.reserva.entities.Ars_reservas_usuEntity;




public interface Ars_reservas_usuDao{
	
	Ars_reservas_usuEntity findByNombre(String nombre);
	
	Ars_reservas_usuDto findByUsuario(String username);
	
	void saveUsuario(Ars_reservas_usuDto usuarioDto);
	
	List<Ars_reservas_usuDto> getUsuarios();
	
	void deleteUsuario(String username);

	void borrarUsuario(Long idUsuario);

	List<Ars_reservas_usuDto> getUsuariosId(Long idl);

	void modificarUsuario(Long idl, String usuario, String apellidos, String email);
}
