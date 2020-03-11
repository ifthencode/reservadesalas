package com.reserva.daos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.reserva.configuration.dao.GenericDao;
import com.reserva.daos.FechasHorasDao;
import com.reserva.daos.ReservasDao;
import com.reserva.daos.UsuarioDao;
import com.reserva.dtos.FechasHorasDto;
import com.reserva.dtos.ReservasDto;
import com.reserva.dtos.SalasDto;
import com.reserva.dtos.UsuarioDto;
import com.reserva.entities.FechasHorasEntity;
import com.reserva.entities.ReservasEntity;
import com.reserva.entities.SalasEntity;
import com.reserva.entities.UsuarioEntity;

@Repository
public class FechasHorasDaoImpl extends GenericDao implements FechasHorasDao {

	
	
	
	
	

	@Override
	public List<FechasHorasDto> getFechasHoras() {
			Query q = entityManager.createQuery(
					" Select e FROM FechasHorasEntity e "
				
					);
			//q.setParameter("true", true);
			
			List<FechasHorasEntity> listFechasHorasEntity = q.getResultList();
			List<FechasHorasDto> listFechasHorasDto = new ArrayList<FechasHorasDto>();
			
			for (FechasHorasEntity fechasHorasEntity : listFechasHorasEntity) {
			
				if(fechasHorasEntity.getDisponible()==true) {
				FechasHorasDto fechasHorasDto = new FechasHorasDto();
			//	BeanUtils.copyProperties(fechasHorasEntity, fechasHorasDto);
				
				fechasHorasDto.setIdfechahora(fechasHorasEntity.getIdfechahora());
				fechasHorasDto.setFecha(fechasHorasEntity.getFecha());
				fechasHorasDto.setHora(fechasHorasEntity.getHora());
				listFechasHorasDto.add(fechasHorasDto);
				}
			}
			return listFechasHorasDto;
	}
	
	

}
