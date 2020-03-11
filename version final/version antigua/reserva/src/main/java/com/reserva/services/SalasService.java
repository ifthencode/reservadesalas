package com.reserva.services;

import java.util.List;

import com.reserva.dtos.SalasDto;
import com.reserva.dtos.UsuarioDto;

public interface SalasService {

	List<SalasDto> getSalas();
	void saveSalas(SalasDto salasDto);
	void borrarSala(Long idSala);
	List<SalasDto> getSalaId(Long idl);
	void modificarSala(Long idl, String usuario, String descripcion);
}
