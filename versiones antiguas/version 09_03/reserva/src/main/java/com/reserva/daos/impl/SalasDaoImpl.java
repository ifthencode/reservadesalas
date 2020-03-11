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
	@Transactional
	public void borrarSalaReservas(Long idSala) {
		
		Query qu = entityManager.createQuery(
				"update ReservasEntity r set r.sala_id = 0 where r.sala_id = :id_sala");
		 qu.setParameter("id_sala", idSala);
		
		  
			int i=qu.executeUpdate();
			
		
		
	}

	@Override
	@Transactional
	public void borrarSala(Long idSala) {
		Query q = entityManager.createQuery(
				"delete from SalasEntity f where f.idsala ="+idSala);
		
		Query qu = entityManager.createQuery("delete from ReservasEntity r where r.sala_id ="+idSala);
		Query qv = entityManager.createQuery("delete from FechasHorasEntity r where r.sala_id ="+idSala);
		// q.setParameter("id", idSala);
		// qu.setParameter("id", idSala);
        int iii=qu.executeUpdate();
		 int iiii=qv.executeUpdate();
		//	borrarSalaReservas(idSala);
			int ii=q.executeUpdate();
		   
		
	}

	@Override
	@Transactional
	public List<SalasDto> getSalasId(Long idl) {
		Query q = entityManager.createQuery(
				"SELECT e FROM SalasEntity e where e.idsala ="+idl);
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
	public void modificarSala(Long idl, String usuario, String descripcion) {
		Query qu = entityManager.createQuery(
				"update SalasEntity s set s.nombre ='"+usuario+"' ,s.descripcion ='"+descripcion+"' where s.idsala ="+idl);
		
		int i=qu.executeUpdate();
		
	}


}
