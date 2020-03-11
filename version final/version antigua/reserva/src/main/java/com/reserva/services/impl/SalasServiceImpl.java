package com.reserva.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserva.daos.SalasDao;
import com.reserva.dtos.SalasDto;
import com.reserva.services.SalasService;

@Service("SalasService")
public class SalasServiceImpl implements SalasService{

	@Autowired
	private SalasDao salasDao;

	@Override
	public List<SalasDto> getSalas() {
		
		return salasDao.getSalas();
	}

	@Override
	public void saveSalas(SalasDto salasDto) {
		
		this.salasDao.saveSala(salasDto);
	}
	@Override
	public void borrarSala(Long idSala) {
		this.salasDao.borrarSala(idSala);
		
	}
    @Override
	public List<SalasDto> getSalaId(Long idl) {
		
    	return salasDao.getSalasId(idl);
	}
    @Override
	public void modificarSala(Long idl, String usuario, String descripcion) {
		
    	this.salasDao.modificarSala(idl,usuario,descripcion);
	}
		
	

}
