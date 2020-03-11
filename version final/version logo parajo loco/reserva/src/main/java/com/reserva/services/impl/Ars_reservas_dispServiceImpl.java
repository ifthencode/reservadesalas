package com.reserva.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserva.daos.Ars_reservas_dispDao;

import com.reserva.dtos.Ars_reservas_dispDto;

import com.reserva.services.Ars_reservas_dispService;


@Service("Ars_reservas_dispService")
public class Ars_reservas_dispServiceImpl implements Ars_reservas_dispService{

	@Autowired
	private Ars_reservas_dispDao ars_reservas_dispDao;

	@Override
	public List<Ars_reservas_dispDto> getFechasHoras() {
		
		return ars_reservas_dispDao.getFechasHoras();
	}

	@Override
	public List<Ars_reservas_dispDto> findById(Long idreserva) {
		// TODO Auto-generated method stub
		return null;
	}
		
	

}
