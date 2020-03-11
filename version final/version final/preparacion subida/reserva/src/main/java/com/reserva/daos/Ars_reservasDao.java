package com.reserva.daos;

import java.util.List;

import com.reserva.dtos.Ars_reservasDto;







public interface Ars_reservasDao{
	
	List<Object[]> getReservas();
	void saveReserva(Ars_reservasDto ars_reservasDto);
	void updateFechasHoras(Ars_reservasDto ars_reservasDto);
	void borrarReserva(Long idReserva);
	Ars_reservasDto findById(Long username);
	List<Object[]> getReservasFecha();
	List<Object[]> getReservasDisponible();
	List<Ars_reservasDto> getReservasId(Long idr);
	void updateFechasHoras(Long newidroom, Long newiddate, Long oldidroom, Long oldiddate, Long idreserve, Long usuariol);
	void updateFechasHoras(Long id);
	void borrarReserva(Long idReserva, Long idDisponibilidad);
}
