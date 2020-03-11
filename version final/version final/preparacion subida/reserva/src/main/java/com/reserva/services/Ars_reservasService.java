package com.reserva.services;

import java.util.List;

import com.reserva.dtos.Ars_reservasDto;



public interface Ars_reservasService {

	  List<Ars_reservasDto> findById(Long idreserva);
	   List<Object[]> getReservas();
	  void updateFechasHoras(Ars_reservasDto reservasDto);
	  void saveReserva(Ars_reservasDto reservasDto);
	  void borrarReserva(Long username);
	  List<Object[]> getReservasFecha();
	  Object getReservasDisponible();
	  List<Ars_reservasDto> getReservasId(Long idr);
	  void modificarReserva(Long newidroom, Long newiddate, Long oldidroom, Long oldiddate, Long idreserve);
	void modificarReserva(Long newidroom, Long newiddate, Long oldidroom, Long oldiddate, Long idreserve,
			Long usuariol);
	void borrarReserva(Long idrl, Long idrd);
}
