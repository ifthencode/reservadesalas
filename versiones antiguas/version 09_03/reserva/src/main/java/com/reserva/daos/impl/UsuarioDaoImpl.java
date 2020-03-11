package com.reserva.daos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.reserva.configuration.dao.GenericDao;
import com.reserva.daos.UsuarioDao;
import com.reserva.dtos.SalasDto;
import com.reserva.dtos.UsuarioDto;
import com.reserva.entities.SalasEntity;
import com.reserva.entities.UsuarioEntity;

@Repository
public class UsuarioDaoImpl extends GenericDao implements UsuarioDao {

	@Override
	public UsuarioEntity findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDto findByUsuario(String username) {
		
		Query q = entityManager.createQuery(
				"FROM UsuarioEntity e WHERE usuario = :username");
			q.setParameter("username", username);
			UsuarioEntity usuarioEntity = (UsuarioEntity)q.getSingleResult();
		UsuarioDto usuarioDto = new UsuarioDto();
		SalasDto rolDto = new SalasDto();
		BeanUtils.copyProperties(usuarioEntity, usuarioDto);
	//	BeanUtils.copyProperties(usuarioEntity.getRol(), rolDto);
	//	usuarioDto.setRol(rolDto);
		
		return usuarioDto;
	}

	@Override
	@Transactional
	public void saveUsuario(UsuarioDto usuarioDto) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
	//	SalasEntity rolEntity = new SalasEntity();		
	//	BeanUtils.copyProperties(usuarioDto.getRol(),rolEntity);
		BeanUtils.copyProperties(usuarioDto, usuarioEntity);	
		//usuarioEntity.setRol(rolEntity);
		
		this.entityManager.persist(usuarioEntity);
		
	}
	
	@Override
	@Transactional
	public void deleteUsuario(String username) {
		this.entityManager.remove(this.findByUsuario(username));		
	}	
	

	@Override
	public List<UsuarioDto> getUsuarios() {
			Query q = entityManager.createQuery(
					"SELECT e FROM UsuarioEntity e"
				//	+ ", RolEntity r WHERE r.id = :rol_id and r.id = e.rol.id"
					);
		//	q.setParameter("rol_id", rol_id);
			
			List<UsuarioEntity> listUsuarioEntity = q.getResultList();
			List<UsuarioDto> listUsuarioDto = new ArrayList<UsuarioDto>();
			for (UsuarioEntity usuarioEntity : listUsuarioEntity) {
				UsuarioDto usuarioDto = new UsuarioDto();
				BeanUtils.copyProperties(usuarioEntity, usuarioDto);
				usuarioDto.setIdusuario(usuarioEntity.getIdusuario());
				listUsuarioDto.add(usuarioDto);
			}
			return listUsuarioDto;
	}

	@Override
	@Transactional
	public void borrarUsuario(Long idUsuario) {
		Query q = entityManager.createQuery(
				"delete from UsuarioEntity f where f.idusuario = :id");
		 q.setParameter("id", idUsuario);
		 Query qu = entityManager.createQuery("delete from ReservasEntity r where r.usuario_id ="+idUsuario);
			int i=qu.executeUpdate();
			i=q.executeUpdate();
		
	}

	@Override
	public List<UsuarioDto> getUsuariosId(Long idl) {
		Query q = entityManager.createQuery(
				"SELECT u FROM UsuarioEntity u where u.idusuario ="+idl);
		List<UsuarioEntity> listUsuarioEntity = q.getResultList();
		List<UsuarioDto> listUsuarioDto = new ArrayList<UsuarioDto>();
		for (UsuarioEntity usuarioEntity : listUsuarioEntity) {
			UsuarioDto usuarioDto = new UsuarioDto();
			BeanUtils.copyProperties(usuarioEntity, usuarioDto);
			usuarioDto.setIdusuario(usuarioEntity.getIdusuario());
			listUsuarioDto.add(usuarioDto);
		}
		 
		return listUsuarioDto;
	}

	@Override
	@Transactional
	public void modificarUsuario(Long idl, String usuario, String apellidos, String email) {
		Query qu = entityManager.createQuery(
				"update UsuarioEntity u set u.nombre ='"+usuario+"' ,u.apellidos ='"+apellidos+"',u.email ='"+email+"' where u.idusuario ="+idl);
		
		int i=qu.executeUpdate();
		
	}

}
