package com.reserva.salas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserva.salas.dao.SalasDao;
import com.reserva.salas.dto.SalasDto;
import com.reserva.salas.service.SalasService;

@Service("SalasService")
public class SalasServiceImpl implements SalasService{

	@Autowired
	private SalasDao salaDao;

	@Override
	public List<SalasDto> getSalas() {
		
		return salaDao.getSalas();
	}
		
	

}
