package com.reserva.daos.impl;

import java.util.ArrayList;
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
import com.reserva.daos.ReservasDao;
import com.reserva.daos.UsuarioDao;
import com.reserva.dtos.ReservasDto;
import com.reserva.dtos.SalasDto;
import com.reserva.dtos.UsuarioDto;
import com.reserva.entities.FechasHorasEntity;
import com.reserva.entities.ReservasEntity;
import com.reserva.entities.SalasEntity;
import com.reserva.entities.UsuarioEntity;

@Repository
public class ReservasDaoImpl extends GenericDao implements ReservasDao {
	 
	/*
	 * @Override public UsuarioEntity findByNombre(String nombre) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public UsuarioDto findByUsuario(String username) {
	 * 
	 * Query q = entityManager.createQuery(
	 * "FROM UsuarioEntity e WHERE usuario = :username"); q.setParameter("username",
	 * username); UsuarioEntity usuarioEntity = (UsuarioEntity)q.getSingleResult();
	 * UsuarioDto usuarioDto = new UsuarioDto(); SalasDto rolDto = new SalasDto();
	 * BeanUtils.copyProperties(usuarioEntity, usuarioDto); //
	 * BeanUtils.copyProperties(usuarioEntity.getRol(), rolDto); //
	 * usuarioDto.setRol(rolDto);
	 * 
	 * return usuarioDto; }
	 */
	@Override
	@Transactional
	public void saveReserva(ReservasDto reservasDto) {
		
	      
		ReservasEntity reservasEntity = new ReservasEntity();
		/*
		 * SalasEntity salasIdEntity = new SalasEntity(); UsuarioEntity
		 * usuarioIdEntity=new UsuarioEntity(); FechasHorasEntity fechahorasEntity=new
		 * FechasHorasEntity();
		 */
		/*
		 * BeanUtils.copyProperties(reservasDto.getSalas(),salasIdEntity);
		 * BeanUtils.copyProperties(reservasDto.getUsuarios(),usuarioIdEntity);
		 * BeanUtils.copyProperties(reservasDto.getFechashoras(),fechahorasEntity);
		 * BeanUtils.copyProperties(reservasDto, reservasEntity);
		 */	
		//usuarioEntity.setRol(rolEntity);
		reservasEntity.setFechahora_id(reservasDto.getSalas().getIdsala());
		reservasEntity.setUsuario_id(reservasDto.getFechashoras().getIdfechahora());
		reservasEntity.setSala_id(reservasDto.getSalas().getIdsala());
		this.entityManager.persist(reservasEntity);
		
	}
	
	/*
	 * @Override
	 * 
	 * @Transactional public void deleteUsuario(String username) {
	 * this.entityManager.remove(this.findByUsuario(username)); }
	 */
	

	@Override
	public List<Object[]> getReservas() {
			Query q = entityManager.createQuery(
					"SELECT s.nombre, f.fecha, f.hora,u.nombre, u.apellidos  FROM ReservasEntity r, FechasHorasEntity f, SalasEntity s,UsuarioEntity u"
					+ " WHERE r.sala_id = s.idsala and r.fechahora_id = f.idfechahora and r.usuario_id=u.idusuario"
					);
		//	q.setParameter("rol_id", rol_id);
			
			List<Object[]> listReservasEntity = q.getResultList();
			
			//List<ReservasDto> listReservasDto = new ArrayList<ReservasDto>();
		/*
		 * for (ReservasEntity reservasEntity : listReservasEntity) { ReservasDto
		 * reservasDto = new ReservasDto(); BeanUtils.copyProperties(reservasEntity,
		 * reservasDto); reservasDto.setIdreserva(reservasEntity.getIdreserva());
		 * listReservasDto.add(reservasDto); }
		 */
			return listReservasEntity;
	}
	@Transactional
	public void updateFechasHoras(ReservasDto reservasDto) {
		Query q = entityManager.createQuery(
				"update FechasHorasEntity f set f.disponible=false where f.idfechahora = :id");
			
				
	  q.setParameter("id", reservasDto.getFechashoras().getIdfechahora());
	  
		int i=q.executeUpdate();
		
		
}
	
}
