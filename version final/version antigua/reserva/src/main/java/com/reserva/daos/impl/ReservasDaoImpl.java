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
		UsuarioEntity usuariosEntity = new UsuarioEntity();
		FechasHorasEntity fechashorasEntity = new FechasHorasEntity();
		SalasEntity salasEntity = new SalasEntity();
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
		BeanUtils.copyProperties(reservasDto.getUsuarios(),usuariosEntity);
		BeanUtils.copyProperties(reservasDto.getFechashoras(),fechashorasEntity);
		BeanUtils.copyProperties(reservasDto.getSalas(),salasEntity);
		//usuarioEntity.setRol(rolEntity);
		BeanUtils.copyProperties(reservasDto, reservasEntity);
	//	reservasEntity.setFechahora_id(reservasDto.getFechashoras());
	//	reservasEntity.setUsuario_id(reservasDto.getUsuarios().getIdusuario());
	//	reservasEntity.setSala_id(reservasDto.getSalas().getIdsala());
		reservasEntity.setUsuario_id(usuariosEntity);
		reservasEntity.setFechahora_id(fechashorasEntity);
		reservasEntity.setSala_id(salasEntity);
		this.entityManager.persist(reservasEntity);
		
	}
	
	/*
	 * @Override
	 * 
	 * @Transactional public void deleteUsuario(String username) {
	 * this.entityManager.remove(this.findByUsuario(username)); }
	 */
	@Override
	public List<Object[]> getReservasFecha() {
			Query q = entityManager.createQuery(
					"SELECT  s.nombre, f.fecha, f.hora ,s.descripcion,f.disponible FROM  FechasHorasEntity f, SalasEntity s"
					+ " WHERE f.fecha= :fecha and f.sala_id=s.idsala"
					);
		//	q.setParameter("rol_id", rol_id);
			java.util.Date fecha = new Date();
			q.setParameter("fecha", fecha);
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

	@Override
	public List<Object[]> getReservas() {
			Query q = entityManager.createQuery(
					"SELECT s.nombre, f.fecha, f.hora,u.nombre, u.apellidos ,r.idreserva FROM ReservasEntity r, FechasHorasEntity f, SalasEntity s,UsuarioEntity u"
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
	@Override
	public List<Object[]> getReservasDisponible() {
			Query q = entityManager.createQuery(
					"SELECT distinct s.nombre, f.fecha, f.hora,f.idfechahora,s.idsala FROM FechasHorasEntity f, SalasEntity s"
					+ " WHERE f.sala_id=s.idsala  and f.disponible='disponible'"
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
				"update FechasHorasEntity f set f.disponible='no disponible' where f.idfechahora = :id");
			
				
	  q.setParameter("id", reservasDto.getFechashoras().getIdfechahora());
	  
		int i=q.executeUpdate();
		
		
}
	@Override
	@Transactional
	public void borrarReserva(Long idReserva) {
		Query q = entityManager.createQuery(
				"delete from ReservasEntity f where f.idreserva = :id");
		 q.setParameter("id", idReserva);
		  
			int i=q.executeUpdate();
	}
	
	@Override
	public ReservasDto findById(Long idReserva) {
		
		Query q = entityManager.createQuery(
				"FROM ReservasEntity e WHERE idreserva = :idreserva");
			q.setParameter("idreserva", idReserva);
		ReservasEntity reservasEntity = (ReservasEntity)q.getSingleResult();
		ReservasDto reservasDto = new ReservasDto();
		BeanUtils.copyProperties(reservasDto, reservasEntity);
		reservasDto.setIdreserva(reservasEntity.getIdreserva());
		
		
		
		return reservasDto;
	}

	@Override
	public List<ReservasDto> getReservasId(Long idr) {
		Query q = entityManager.createQuery(
				"SELECT r FROM ReservasEntity r, FechasHorasEntity f,SalasEntity s,UsuarioEntity u WHERE r.idreserva = :idr and f.idfechahora=r.fechahora_id.idfechahora and s.idsala = r.sala_id.idsala and u.idusuario=r.usuario_id.idusuario");
		q.setParameter("idr", idr);
		
		List<ReservasEntity> listReservasEntity = q.getResultList();
		List<ReservasDto> listReservasDto = new ArrayList<ReservasDto>();
		for (ReservasEntity reservasEntity : listReservasEntity) {
			ReservasDto reservasDto = new ReservasDto();
			FechasHorasDto fechasHorasDto=new FechasHorasDto();
		    SalasDto salasDto=new SalasDto();
		    UsuarioDto usuariosDto=new UsuarioDto();
		    
			/*
			 * BeanUtils.copyProperties(fechasHorasDto,reservasEntity );
			 * 
			 * BeanUtils.copyProperties(reservasEntity, fechasHorasDto);
			 * BeanUtils.copyProperties(reservasEntity, salasDto);
			 * BeanUtils.copyProperties(reservasEntity, usuariosDto);
			 * 
			 * 
			 * BeanUtils.copyProperties(fechasHorasDto, reservasDto);
			 * BeanUtils.copyProperties(salasDto, reservasDto);
			 * BeanUtils.copyProperties(usuariosDto, reservasDto);
			 */
			
			fechasHorasDto.setFecha(reservasEntity.getFechahora_id().getFecha());
			fechasHorasDto.setHora(reservasEntity.getFechahora_id().getHora());
			salasDto.setIdsala(reservasEntity.getSala_id().getIdsala());
			salasDto.setNombre(reservasEntity.getSala_id().getNombre());
			fechasHorasDto.setSala_id(salasDto.getIdsala());
			fechasHorasDto.setIdfechahora(reservasEntity.getFechahora_id().getIdfechahora());
			usuariosDto.setIdusuario(reservasEntity.getUsuario_id().getIdusuario());
			usuariosDto.setNombre(reservasEntity.getUsuario_id().getNombre());
			usuariosDto.setApellidos(reservasEntity.getUsuario_id().getApellidos());
			reservasDto.setFechashoras(fechasHorasDto);
			reservasDto.setSalas(salasDto);
			reservasDto.setUsuarios(usuariosDto);
			reservasDto.setIdreserva(idr);
			listReservasDto.add(reservasDto);
		}
		return listReservasDto;
	}

	@Override
	@Transactional
	public void updateFechasHoras(Long newidroom, Long newiddate, Long oldidroom, Long oldiddate, Long idreserve,Long usuariol) {
		Query q = entityManager.createQuery(
				"update FechasHorasEntity f set f.disponible='disponible' where f.idfechahora = :id");
	     q.setParameter("id",oldiddate );
	     Query qa = entityManager.createQuery(
					"update FechasHorasEntity f set f.disponible='no disponible' where f.idfechahora = :id");
		     qa.setParameter("id",newiddate );
	    Query qu = entityManager.createQuery(
				"update ReservasEntity r set r.sala_id ="+newidroom+" ,r.usuario_id = "+usuariol+", r.fechahora_id ="+newiddate+" where r.idreserva ="+idreserve);
	    int i=q.executeUpdate();
	    int ia=qa.executeUpdate();
		int iu=qu.executeUpdate();
		
	}
}
