package com.reserva.daos;

import java.util.List;

import com.reserva.dtos.FechasHorasDto;
import com.reserva.dtos.ReservasDto;
import com.reserva.dtos.SalasDto;
import com.reserva.dtos.UsuarioDto;



public interface FechasHorasDao{
	
	List<FechasHorasDto> getFechasHoras();
	
}
