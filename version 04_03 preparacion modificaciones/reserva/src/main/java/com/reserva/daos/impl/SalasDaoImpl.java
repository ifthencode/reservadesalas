package com.reserva.daos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.reserva.configuration.dao.GenericDao;
import com.reserva.daos.SalasDao;
import com.reserva.dtos.SalasDto;
import com.reserva.dtos.UsuarioDto;
import com.reserva.entities.SalasEntity;
import com.reserva.entities.UsuarioEntity;

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

	@Override
	@Transactional
	public void saveSala(SalasDto salasDto) {
		SalasEntity salasEntity = new SalasEntity();
	//	SalasEntity rolEntity = new SalasEntity();		
	//	BeanUtils.copyProperties(usuarioDto.getRol(),rolEntity);
		BeanUtils.copyProperties(salasDto, salasEntity);	
		//usuarioEntity.setRol(rolEntity);
		this.entityManager.persist(salasEntity);
		
	}

	@Override
	@Transactional
	public void borrarSala(Long idSala) {
		Query q = entityManager.createQuery(
				"delete from SalasEntity f where f.idsala = :id");
		 q.setParameter("id", idSala);
		  
			int i=q.executeUpdate();
		
		
	}


}
