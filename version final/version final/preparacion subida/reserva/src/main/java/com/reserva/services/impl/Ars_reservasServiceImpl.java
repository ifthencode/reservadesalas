package com.reserva.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reserva.daos.Ars_reservasDao;
import com.reserva.dtos.Ars_reservasDto;
import com.reserva.services.Ars_reservasService;



@Service("ars_reservasService")
public class Ars_reservasServiceImpl implements Ars_reservasService{

	@Autowired
	private Ars_reservasDao ars_reservasDao;
	
	
		
	
	
	  public void saveReserva(Ars_reservasDto ars_reservasDto) {
	  this.ars_reservasDao.saveReserva(ars_reservasDto); }
	 
	  public void updateFechasHoras(Ars_reservasDto ars_reservasDto) {
		  this.ars_reservasDao.updateFechasHoras(ars_reservasDto); }

	@Override
	public List<Ars_reservasDto> findById(Long idreserva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> getReservas() {
		// TODO Auto-generated method stub
		return this.ars_reservasDao.getReservas();
	}
	@Override
	public void borrarReserva(Long idReserva) {
		this.ars_reservasDao.borrarReserva(idReserva);
		
	}
	@Override
	public List<Object[]> getReservasFecha() {
		
		return this.ars_reservasDao.getReservasFecha();
	}
   @Override
	public Object getReservasDisponible() {
		// TODO Auto-generated method stub
		return this.ars_reservasDao.getReservasDisponible();
	}
    @Override
	public List<Ars_reservasDto> getReservasId(Long idr) {
		
		return this.ars_reservasDao.getReservasId(idr);
	}
    @Override
	public void modificarReserva(Long newidroom, Long newiddate, Long oldidroom, Long oldiddate, Long idreserve, Long usuariol) {
    	this.ars_reservasDao.updateFechasHoras(newidroom,newiddate,oldidroom,oldiddate,idreserve,usuariol);
		
	}

	@Override
	public void modificarReserva(Long newidroom, Long newiddate, Long oldidroom, Long oldiddate, Long idreserve) {
		// TODO Auto-generated method stub
		
	}
  @Override
	public void borrarReserva(Long idrl, Long idrd) {
	  this.ars_reservasDao.borrarReserva(idrl,idrd);
		
	}

	
	

	
	
	

}
