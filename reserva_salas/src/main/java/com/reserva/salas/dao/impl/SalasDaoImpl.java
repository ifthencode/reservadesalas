package com.reserva.salas.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.reserva.salas.configuration.dao.GenericDao;
import com.reserva.salas.dao.SalasDao;
import com.reserva.salas.dto.SalasDto;
import com.reserva.salas.entity.SalasEntity;

@Repository
public class SalasDaoImpl extends GenericDao implements SalasDao {

	@Override
	public List<SalasDto> getSalas() {
		Query q = entityManager.createQuery(
				"FROM salas s");
		List<SalasEntity> listSalasEntity = q.getResultList();
		List<SalasDto> listSalasDto = new ArrayList<SalasDto>();
		
		for (int i = 0; i < listSalasEntity.size(); i++) {
			SalasEntity rolEntity  = listSalasEntity.get(i);
			SalasDto rolDto = new SalasDto();
			BeanUtils.copyProperties(rolEntity, rolDto );
			listSalasDto.add(rolDto);
		}
		 
		return listSalasDto;
	}


}
