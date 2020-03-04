package com.reserva.services;

import java.util.List;

import com.reserva.dtos.ReservasDto;


public interface ReservasService {

	List<ReservasDto> findById(Long idreserva);
	  public List<Object[]> getReservas();
	  public void updateFechasHoras(ReservasDto reservasDto);
	  public void saveReserva(ReservasDto reservasDto);
	 void borrarReserva(Long username);
	List<Object[]> getReservasFecha();
}
