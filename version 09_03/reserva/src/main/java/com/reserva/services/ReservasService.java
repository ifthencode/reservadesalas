package com.reserva.services;

import java.util.List;

import com.reserva.dtos.ReservasDto;


public interface ReservasService {

	  List<ReservasDto> findById(Long idreserva);
	   List<Object[]> getReservas();
	  void updateFechasHoras(ReservasDto reservasDto);
	  void saveReserva(ReservasDto reservasDto);
	  void borrarReserva(Long username);
	  List<Object[]> getReservasFecha();
	  Object getReservasDisponible();
	  List<ReservasDto> getReservasId(Long idr);
	  void modificarReserva(Long newidroom, Long newiddate, Long oldidroom, Long oldiddate, Long idreserve);
	void modificarReserva(Long newidroom, Long newiddate, Long oldidroom, Long oldiddate, Long idreserve,
			Long usuariol);
}
