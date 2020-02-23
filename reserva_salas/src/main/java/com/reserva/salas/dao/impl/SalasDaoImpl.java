package com.reserva.salas.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.reserva.salas.configuration.dao.GenericDao;
import com.reserva.salas.dao.SalasDao;
import com.reserva.salas.dto.SalasDto;
import com.reserva.salas.dto.UsuarioDto;
import com.reserva.salas.entity.SalasEntity;
import com.reserva.salas.entity.UsuarioEntity;

@Repository
public class SalasDaoImpl extends GenericDao implements SalasDao {

	@Override
	public List<SalasDto> getSalas() {
		Query q = entityManager.createQuery(
				"SELECT e FROM SalasEntity e");
		List<SalasEntity> listSalasEntity = q.getResultList();
		List<SalasDto> listSalasDto = new ArrayList<SalasDto>();
		for (SalasEntity salasEntity : listSalasEntity) {
			SalasDto salasDto = new SalasDto();
			BeanUtils.copyProperties(salasEntity, salasDto);
			salasDto.setIdsala(salasEntity.getIdsala());
			listSalasDto.add(salasDto);
		}
		 
		return listSalasDto;
	}


}
