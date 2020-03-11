package com.reserva.daos.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.reserva.configuration.dao.GenericDao;
import com.reserva.daos.Ars_reservasDao;
import com.reserva.dtos.Ars_reservasDto;
import com.reserva.dtos.Ars_reservas_dispDto;
import com.reserva.dtos.Ars_reservas_salDto;
import com.reserva.dtos.Ars_reservas_usuDto;
import com.reserva.entities.Ars_reservasEntity;
import com.reserva.entities.Ars_reservas_dispEntity;
import com.reserva.entities.Ars_reservas_salEntity;
import com.reserva.entities.Ars_reservas_usuEntity;




@Repository
public class Ars_reservasDaoImpl extends GenericDao implements Ars_reservasDao {
	 
	
	@Override
	@Transactional
	public void saveReserva(Ars_reservasDto ars_reservasDto) {
		
	      
		Ars_reservasEntity ars_reservasEntity = new Ars_reservasEntity();
		Ars_reservas_usuEntity usuariosEntity = new Ars_reservas_usuEntity();
		Ars_reservas_dispEntity ars_reservas_dispEntity = new Ars_reservas_dispEntity();
		Ars_reservas_salEntity ars_reservas_salEntity = new Ars_reservas_salEntity();
		
		BeanUtils.copyProperties(ars_reservasDto.getArs_reservas_usu(),usuariosEntity);
		BeanUtils.copyProperties(ars_reservasDto.getArs_reservas_disp(),ars_reservas_dispEntity);
		BeanUtils.copyProperties(ars_reservasDto.getArs_reservas_sal(),ars_reservas_salEntity);

		BeanUtils.copyProperties(ars_reservasDto, ars_reservasEntity);

		ars_reservasEntity.setUsuario_id(usuariosEntity);
		ars_reservasEntity.setFk_id_disponibilidad(ars_reservas_dispEntity);
		ars_reservasEntity.setFk_id_sala(ars_reservas_salEntity);
		this.entityManager.persist(ars_reservasEntity);
		
	}
	
	@Override
	public List<Object[]> getReservasFecha() {
			Query q = entityManager.createQuery(
					"SELECT  s.var_nombre_sala, f.date_fecha_disponibilidad, f.time_hora_disponibilidad ,s.var_descripcion_sala,f.var_disponible FROM  Ars_reservas_dispEntity f, Ars_reservas_salEntity s"
					+ " WHERE f.date_fecha_disponibilidad= :date_fecha_disponibilidad and f.fk_id_sala=s.pk_id_sala"
					);
		
			java.util.Date date_fecha_disponibilidad = new Date();
			q.setParameter("date_fecha_disponibilidad", date_fecha_disponibilidad);
			List<Object[]> listReservasEntity = q.getResultList();
			
		
			return listReservasEntity;
	}
	//sala_id 

	@Override
	public List<Object[]> getReservas() {
			Query q = entityManager.createQuery(
					"SELECT s.var_nombre_sala, f.date_fecha_disponibilidad, f.time_hora_disponibilidad,u.var_nombre_usuario, u.var_apellidos_usuario ,r.pk_id_reserva,r.fk_id_disponibilidad FROM Ars_reservasEntity r, Ars_reservas_dispEntity f, Ars_reservas_salEntity s,Ars_reservas_usuEntity u"
					+ " WHERE r.fk_id_sala = s.pk_id_sala and r.fk_id_disponibilidad = f.pk_id_disponibilidad and r.fk_id_usuario=u.pk_id_usuario"
					);
		
			
			List<Object[]> listReservasEntity = q.getResultList();
			//ReservasEntity
			
			return listReservasEntity;
	}
	
	//nombre
	@Override
	public List<Object[]> getReservasDisponible() {
			Query q = entityManager.createQuery(
					"SELECT distinct s.var_nombre_sala, f.date_fecha_disponibilidad, f.time_hora_disponibilidad,f.pk_id_disponibilidad,s.pk_id_sala FROM Ars_reservas_dispEntity f, Ars_reservas_salEntity s"
					+ " WHERE f.fk_id_sala=s.pk_id_sala  and f.var_disponible='disponible'"
					);
		
			
			List<Object[]> listReservasEntity = q.getResultList();
			
		
			return listReservasEntity;
	}
	@Transactional
	public void updateFechasHoras(Ars_reservasDto ars_reservasDto) {
		Query q = entityManager.createQuery(
				"update Ars_reservas_dispEntity f set f.var_disponible='no disponible' where f.pk_id_disponibilidad = :id");
			
				
	  q.setParameter("id", ars_reservasDto.getArs_reservas_disp().getPk_id_disponibilidad());
	  
		int i=q.executeUpdate();
		
		
  }
	@Transactional
	@Override
	public void updateFechasHoras(Long idld) {
		Query q = entityManager.createQuery(
				"update Ars_reservas_dispEntity f set f.var_disponible='disponible' where f.pk_id_disponibilidad = :id");
			
				
	  q.setParameter("id", idld);
	  
		int i=q.executeUpdate();
		
		//idreserva 
  }
	@Override
	@Transactional
	public void borrarReserva(Long idReserva) {
		Query q = entityManager.createQuery(
				"delete from Ars_reservasEntity f where f.pk_id_reserva = :id");
		 q.setParameter("id", idReserva);
		  
			int i=q.executeUpdate();
	}
	
	@Override
	public Ars_reservasDto findById(Long idReserva) {
		
		Query q = entityManager.createQuery(
				"FROM Ars_reservasEntity e WHERE pk_id_reserva = :idreserva");
			q.setParameter("idreserva", idReserva);
			Ars_reservasEntity reservasEntity = (Ars_reservasEntity)q.getSingleResult();
			Ars_reservasDto ars_reservasDto = new Ars_reservasDto();
		BeanUtils.copyProperties(ars_reservasDto, reservasEntity);
		ars_reservasDto.setPk_id_reserva(reservasEntity.getPk_id_reserva());
		
		
		
		return ars_reservasDto;
	}

	@Override
	public List<Ars_reservasDto> getReservasId(Long idr) {
		Query q = entityManager.createQuery(
				"SELECT r FROM Ars_reservasEntity r, Ars_reservas_dispEntity f,Ars_reservas_salEntity s,Ars_reservas_usuEntity u WHERE r.pk_id_reserva = :idr and f.pk_id_disponibilidad=r.fk_id_disponibilidad and s.pk_id_sala = r.fk_id_sala and u.pk_id_usuario=r.fk_id_usuario");
		q.setParameter("idr", idr);
		
		List<Ars_reservasEntity> listArs_reservasEntity = q.getResultList();
		List<Ars_reservasDto> listArs_reservasDto = new ArrayList<Ars_reservasDto>();
		for (Ars_reservasEntity reservasEntity : listArs_reservasEntity) {
			Ars_reservasDto ars_reservasDto = new Ars_reservasDto();
			Ars_reservas_dispDto ars_reservas_dispDto=new Ars_reservas_dispDto();
			Ars_reservas_salDto salasDto=new Ars_reservas_salDto();
		    Ars_reservas_usuDto ars_reservas_usuDto=new Ars_reservas_usuDto();
		    //SalasEntity 
			//nombre
			
		    ars_reservas_dispDto.setDate_fecha_disponibilidad(reservasEntity.getPk_id_disponibilidad().getDate_fecha_disponibilidad());
		    ars_reservas_dispDto.setTime_hora_disponibilidad(reservasEntity.getPk_id_disponibilidad().getTime_hora_disponibilidad());
			salasDto.setPk_id_sala(reservasEntity.getFk_id_sala().getPk_id_sala());
			salasDto.setVar_nombre_sala(reservasEntity.getFk_id_sala().getVar_nombre_sala());
			ars_reservas_dispDto.setFk_id_sala(salasDto.getPk_id_sala());
			ars_reservas_dispDto.setPk_id_disponibilidad(reservasEntity.getPk_id_disponibilidad().getPk_id_disponibilidad());
			ars_reservas_usuDto.setPk_id_usuario(reservasEntity.getUsuario_id().getPk_id_usuario());
			ars_reservas_usuDto.setVar_nombre_usuario(reservasEntity.getUsuario_id().getVar_nombre_usuario());
			ars_reservas_usuDto.setVar_apellidos_usuario(reservasEntity.getUsuario_id().getVar_apellidos_usuario());
			ars_reservasDto.setArs_reservas_disp(ars_reservas_dispDto);
			ars_reservasDto.setArs_reservas_sal(salasDto);
			ars_reservasDto.setArs_reservas_usu(ars_reservas_usuDto);
			ars_reservasDto.setPk_id_reserva(idr);
			listArs_reservasDto.add(ars_reservasDto);
		}
		return listArs_reservasDto;
	}
   //apellidos
	@Override
	@Transactional
	public void updateFechasHoras(Long newidroom, Long newiddate, Long oldidroom, Long oldiddate, Long idreserve,Long usuariol) {
		Query q = entityManager.createQuery(
				"update Ars_reservas_dispEntity f set f.var_disponible='disponible' where f.pk_id_disponibilidad = :id");
	     q.setParameter("id",oldiddate );
	     Query qa = entityManager.createQuery(
					"update Ars_reservas_dispEntity f set f.var_disponible='no disponible' where f.pk_id_disponibilidad = :id");
		     qa.setParameter("id",newiddate );
	    Query qu = entityManager.createQuery(
				"update Ars_reservasEntity r set r.fk_id_sala ="+newidroom+" ,r.fk_id_usuario = "+usuariol+", r.fk_id_disponibilidad ="+newiddate+" where r.pk_id_reserva ="+idreserve);
	    int i=q.executeUpdate();
	    int ia=qa.executeUpdate();
		int iu=qu.executeUpdate();
		
	}

	

	@Override
	@Transactional
	public void borrarReserva(Long idReserva, Long idDisponibilidad) {
		Query q = entityManager.createQuery(
				"delete from Ars_reservasEntity f where f.pk_id_reserva = :id");
		 q.setParameter("id", idReserva);
		 
			int i=q.executeUpdate();
			updateFechasHoras(idDisponibilidad);
		
	}
}
