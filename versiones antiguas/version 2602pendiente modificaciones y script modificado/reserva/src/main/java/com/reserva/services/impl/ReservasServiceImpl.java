package com.reserva.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reserva.daos.ReservasDao;
import com.reserva.daos.UsuarioDao;
import com.reserva.dtos.ReservasDto;
import com.reserva.dtos.UsuarioDto;
import com.reserva.services.ReservasService;
import com.reserva.services.UsuarioService;

@Service("reservasService")
public class ReservasServiceImpl implements ReservasService{

	@Autowired
	private ReservasDao reservasDao;
	
	
		
	
	
	  public void saveReserva(ReservasDto reservasDto) {
	  this.reservasDao.saveReserva(reservasDto); }
	 
	  public void updateFechasHoras(ReservasDto reservasDto) {
		  this.reservasDao.updateFechasHoras(reservasDto); }

	@Override
	public List<ReservasDto> findById(Long idreserva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> getReservas() {
		// TODO Auto-generated method stub
		return this.reservasDao.getReservas();
	}

	
	

	
	
	

}
