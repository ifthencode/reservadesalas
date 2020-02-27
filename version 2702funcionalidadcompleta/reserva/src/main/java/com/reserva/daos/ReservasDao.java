package com.reserva.daos;

import java.util.List;

import com.reserva.dtos.ReservasDto;
import com.reserva.dtos.SalasDto;
import com.reserva.dtos.UsuarioDto;



public interface ReservasDao{
	
	List<Object[]> getReservas();
	void saveReserva(ReservasDto reservaDto);
	void updateFechasHoras(ReservasDto reservaDto);
}
