package com.reserva.services;

import java.util.List;

import com.reserva.dtos.SalasDto;
import com.reserva.dtos.UsuarioDto;

public interface SalasService {

	List<SalasDto> getSalas();
	void saveSalas(SalasDto salasDto);
}
