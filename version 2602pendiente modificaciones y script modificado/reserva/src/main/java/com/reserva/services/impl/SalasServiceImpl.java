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
		// TODO Auto-generated method stub
		this.salasDao.saveSala(salasDto);
	}
		
	

}
