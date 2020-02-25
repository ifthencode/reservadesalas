package com.reserva.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserva.daos.FechasHorasDao;
import com.reserva.daos.SalasDao;
import com.reserva.dtos.FechasHorasDto;
import com.reserva.dtos.SalasDto;
import com.reserva.services.FechasHorasService;
import com.reserva.services.SalasService;

@Service("FechasHorassService")
public class FechasHorasServiceImpl implements FechasHorasService{

	@Autowired
	private FechasHorasDao fechasHorasDao;

	@Override
	public List<FechasHorasDto> getFechasHoras() {
		
		return fechasHorasDao.getFechasHoras();
	}

	@Override
	public List<FechasHorasDto> findById(Long idreserva) {
		// TODO Auto-generated method stub
		return null;
	}
		
	

}
