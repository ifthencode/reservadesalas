package com.reserva.daos;

import java.util.List;

import com.reserva.dtos.ReservasDto;
import com.reserva.dtos.SalasDto;
import com.reserva.dtos.UsuarioDto;



public interface ReservasDao{
	
	List<ReservasDto> getReservas();
	void saveReserva(ReservasDto reservaDto);
}
