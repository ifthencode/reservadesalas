package com.reserva.daos;

import java.util.List;

import com.reserva.dtos.Ars_reservas_salDto;





public interface Ars_reservas_salDao{
	
	List<Ars_reservas_salDto> getSalas();
	void saveSala(Ars_reservas_salDto salasDto);
	void borrarSala(Long idSala);
	List<Ars_reservas_salDto> getSalasId(Long idl);
	void modificarSala(Long idl, String usuario, String descripcion);
}
