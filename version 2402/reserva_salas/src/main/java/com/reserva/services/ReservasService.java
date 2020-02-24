package com.reserva.services;

import java.util.List;

import com.reserva.dtos.ReservasDto;


public interface ReservasService {

	List<ReservasDto> findById(Long idreserva);
}
