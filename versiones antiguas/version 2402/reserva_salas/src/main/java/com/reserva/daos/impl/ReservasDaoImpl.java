package com.reserva.daos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
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
		SalasEntity salasIdEntity = new SalasEntity();
		UsuarioEntity usuarioIdEntity=new UsuarioEntity();
		FechasHorasEntity fechahorasEntity=new FechasHorasEntity();
		BeanUtils.copyProperties(reservasDto.getSalas(),salasIdEntity);
		BeanUtils.copyProperties(reservasDto.getUsuarios(),usuarioIdEntity);
		BeanUtils.copyProperties(reservasDto.getFechashoras(),fechahorasEntity);
		BeanUtils.copyProperties(reservasDto, reservasEntity);	
		//usuarioEntity.setRol(rolEntity);
		reservasEntity.setFechahora_id(fechahorasEntity);
		reservasEntity.setUsuario_id(usuarioIdEntity);
		reservasEntity.setSala_id(salasIdEntity);
		this.entityManager.persist(reservasEntity);
		
	}
	
	/*
	 * @Override
	 * 
	 * @Transactional public void deleteUsuario(String username) {
	 * this.entityManager.remove(this.findByUsuario(username)); }
	 */
	

	@Override
	public List<ReservasDto> getReservas() {
			Query q = entityManager.createQuery(
					"SELECT e FROM ReservasEntity e"
				//	+ ", RolEntity r WHERE r.id = :rol_id and r.id = e.rol.id"
					);
		//	q.setParameter("rol_id", rol_id);
			
			List<ReservasEntity> listReservasEntity = q.getResultList();
			List<ReservasDto> listReservasDto = new ArrayList<ReservasDto>();
			for (ReservasEntity reservasEntity : listReservasEntity) {
				ReservasDto reservasDto = new ReservasDto();
				BeanUtils.copyProperties(reservasEntity, reservasDto);
				reservasDto.setIdreserva(reservasEntity.getIdreserva());
				listReservasDto.add(reservasDto);
			}
			return listReservasDto;
	}

}
