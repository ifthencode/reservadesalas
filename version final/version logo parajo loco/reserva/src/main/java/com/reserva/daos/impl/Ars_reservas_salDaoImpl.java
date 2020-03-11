package com.reserva.daos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.reserva.configuration.dao.GenericDao;
import com.reserva.daos.Ars_reservas_salDao;
import com.reserva.dtos.Ars_reservas_salDto;
import com.reserva.entities.Ars_reservas_salEntity;



@Repository
public class Ars_reservas_salDaoImpl extends GenericDao implements Ars_reservas_salDao {

	@Override
	public List<Ars_reservas_salDto> getSalas() {
		Query q = entityManager.createQuery(
				"SELECT e FROM Ars_reservas_salEntity e");
		List<Ars_reservas_salEntity> listArs_reservas_salEntity = q.getResultList();
		List<Ars_reservas_salDto> listSalasDto = new ArrayList<Ars_reservas_salDto>();
		for (Ars_reservas_salEntity ars_reservas_salEntity : listArs_reservas_salEntity) {
			Ars_reservas_salDto ars_reservas_salDto = new Ars_reservas_salDto();
			BeanUtils.copyProperties(ars_reservas_salEntity, ars_reservas_salDto);
			ars_reservas_salDto.setPk_id_sala(ars_reservas_salEntity.getPk_id_sala());
			listSalasDto.add(ars_reservas_salDto);
		}
		 
		return listSalasDto;
	}

	@Override
	@Transactional
	public void saveSala(Ars_reservas_salDto ars_reservas_salDto) {
		Ars_reservas_salEntity ars_reservas_salEntity = new Ars_reservas_salEntity();
	//	SalasEntity rolEntity = new SalasEntity();		
	//	BeanUtils.copyProperties(usuarioDto.getRol(),rolEntity);
		BeanUtils.copyProperties(ars_reservas_salDto, ars_reservas_salEntity);	
		//usuarioEntity.setRol(rolEntity);
		this.entityManager.persist(ars_reservas_salEntity);
		
	}

	/*
	 * @Transactional public void borrarSalaReservas(Long idSala) {
	 * 
	 * Query qu = entityManager.createQuery(
	 * "update Ars_reservasEntity r set r.pk_id_sala = 0 where r.sala_id = :id_sala"
	 * ); qu.setParameter("id_sala", idSala);
	 * 
	 * 
	 * int i=qu.executeUpdate();
	 * 
	 * 
	 * 
	 * }
	 */
	@Override
	@Transactional
	public void borrarSala(Long idSala) {
		Query q = entityManager.createQuery(
				"delete from Ars_reservas_salEntity f where f.idsala ="+idSala);
		// ReservasEntity
		Query qu = entityManager.createQuery("delete from Ars_reservasEntity r where r.sala_id ="+idSala);
		Query qv = entityManager.createQuery("delete from Ars_reservas_dispEntity r where r.sala_id ="+idSala);
		// q.setParameter("id", idSala);
		// qu.setParameter("id", idSala);
        int iii=qu.executeUpdate();
		int iiii=qv.executeUpdate();
		//	borrarSalaReservas(idSala);
			int ii=q.executeUpdate();
		   
		
	}

	@Override
	@Transactional
	public List<Ars_reservas_salDto> getSalasId(Long idl) {
		Query q = entityManager.createQuery(
				"SELECT e FROM Ars_reservas_salEntity e where e.pk_id_sala ="+idl);
		List<Ars_reservas_salEntity> listArs_reservas_salEntity = q.getResultList();
		List<Ars_reservas_salDto> listSalasDto = new ArrayList<Ars_reservas_salDto>();
		for (Ars_reservas_salEntity ars_reservas_salEntity : listArs_reservas_salEntity) {
			Ars_reservas_salDto salasDto = new Ars_reservas_salDto();
			BeanUtils.copyProperties(ars_reservas_salEntity, salasDto);
			salasDto.setPk_id_sala(ars_reservas_salEntity.getPk_id_sala());
			listSalasDto.add(salasDto);
		}
		 
		return listSalasDto;
	}

	@Override
	@Transactional
	public void modificarSala(Long idl, String nombre, String descripcion) {
		Query qu = entityManager.createQuery(
				"update Ars_reservas_salEntity s set s.var_nombre_sala ='"+nombre+"' ,s.var_descripcion_sala ='"+descripcion+"' where s.pk_id_sala ="+idl);
		
		int i=qu.executeUpdate();
		
	}


}
