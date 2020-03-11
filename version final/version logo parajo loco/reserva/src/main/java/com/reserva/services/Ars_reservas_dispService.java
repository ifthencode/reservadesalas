package com.reserva.services;

import java.util.List;

import com.reserva.dtos.Ars_reservas_dispDto;



public interface Ars_reservas_dispService {

	List<Ars_reservas_dispDto> findById(Long idreserva);

	List<Ars_reservas_dispDto> getFechasHoras();
}
