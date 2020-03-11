package com.reserva.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserva.daos.Ars_reservas_salDao;
import com.reserva.dtos.Ars_reservas_salDto;
import com.reserva.services.Ars_reservas_salService;


@Service("Ars_reservas_salService")
public class Ars_reservas_salServiceImpl implements Ars_reservas_salService{

	@Autowired
	private Ars_reservas_salDao ars_reservas_salDao;

	@Override
	public List<Ars_reservas_salDto> getSalas() {
		
		return ars_reservas_salDao.getSalas();
	}

	@Override
	public void saveSalas(Ars_reservas_salDto salasDto) {
		
		this.ars_reservas_salDao.saveSala(salasDto);
	}
	@Override
	public void borrarSala(Long idSala) {
		this.ars_reservas_salDao.borrarSala(idSala);
		
	}
    @Override
	public List<Ars_reservas_salDto> getSalaId(Long idl) {
		
    	return ars_reservas_salDao.getSalasId(idl);
	}
    @Override
	public void modificarSala(Long idl, String usuario, String descripcion) {
		
    	this.ars_reservas_salDao.modificarSala(idl,usuario,descripcion);
	}
		
	

}
