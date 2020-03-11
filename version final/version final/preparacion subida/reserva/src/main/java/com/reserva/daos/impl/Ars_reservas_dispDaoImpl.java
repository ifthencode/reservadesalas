package com.reserva.daos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.reserva.configuration.dao.GenericDao;
import com.reserva.daos.Ars_reservas_dispDao;


import com.reserva.dtos.Ars_reservas_dispDto;



import com.reserva.entities.Ars_reservas_dispEntity;



@Repository
public class Ars_reservas_dispDaoImpl extends GenericDao implements Ars_reservas_dispDao {

	//sala_id
	
	
	
	

	@Override
	public List<Ars_reservas_dispDto> getFechasHoras() {
			Query q = entityManager.createQuery(
					" Select e FROM Ars_reservas_dispEntity e "
				
					);
			//q.setParameter("true", true);
			
			List<Ars_reservas_dispEntity> listArs_reservas_dispEntity = q.getResultList();
			List<Ars_reservas_dispDto> listArs_reservas_dispDto = new ArrayList<Ars_reservas_dispDto>();
			
			for (Ars_reservas_dispEntity ars_reservas_dispEntity : listArs_reservas_dispEntity) {
			
				if(ars_reservas_dispEntity.getVar_disponible().equals("disponible")) {
					Ars_reservas_dispDto ars_reservas_dispDto = new Ars_reservas_dispDto();
			
				
					ars_reservas_dispDto.setPk_id_disponibilidad(ars_reservas_dispEntity.getPk_id_disponibilidad());
					ars_reservas_dispDto.setDate_fecha_disponibilidad(ars_reservas_dispEntity.getDate_fecha_disponibilidad());
					ars_reservas_dispDto.setTime_hora_disponibilidad(ars_reservas_dispEntity.getTime_hora_disponibilidad());
					listArs_reservas_dispDto.add(ars_reservas_dispDto);
				}
			}
			return listArs_reservas_dispDto;
	}
	
	

}
