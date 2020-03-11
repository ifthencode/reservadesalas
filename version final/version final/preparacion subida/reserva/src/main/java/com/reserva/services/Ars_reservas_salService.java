package com.reserva.services;

import java.util.List;

import com.reserva.dtos.Ars_reservas_salDto;



public interface Ars_reservas_salService {

	List<Ars_reservas_salDto> getSalas();
	void saveSalas(Ars_reservas_salDto ars_reservas_salDto);
	void borrarSala(Long idSala);
	List<Ars_reservas_salDto> getSalaId(Long idl);
	void modificarSala(Long idl, String usuario, String descripcion);
}
