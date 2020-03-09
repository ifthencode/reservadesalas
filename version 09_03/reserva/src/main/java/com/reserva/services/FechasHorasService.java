package com.reserva.services;

import java.util.List;

import com.reserva.dtos.FechasHorasDto;
import com.reserva.dtos.ReservasDto;


public interface FechasHorasService {

	List<FechasHorasDto> findById(Long idreserva);

	List<FechasHorasDto> getFechasHoras();
}
