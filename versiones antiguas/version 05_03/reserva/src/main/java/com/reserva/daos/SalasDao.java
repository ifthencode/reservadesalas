package com.reserva.daos;

import java.util.List;

import com.reserva.dtos.ReservasDto;
import com.reserva.dtos.SalasDto;



public interface SalasDao{
	
	List<SalasDto> getSalas();
	void saveSala(SalasDto salasDto);
	void borrarSala(Long idSala);
}
