package com.reserva.daos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.reserva.configuration.dao.GenericDao;
import com.reserva.daos.Ars_reservas_usuDao;
import com.reserva.dtos.Ars_reservas_usuDto;

import com.reserva.entities.Ars_reservas_usuEntity;


@Repository
public class Ars_reservas_usuImpl extends GenericDao implements Ars_reservas_usuDao {

	@Override
	public Ars_reservas_usuEntity findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ars_reservas_usuDto findByUsuario(String username) {
		
		Query q = entityManager.createQuery(
				"FROM Ars_reservas_usuEntity e WHERE usuario = :username");
			q.setParameter("username", username);
			Ars_reservas_usuEntity usuarioEntity = (Ars_reservas_usuEntity)q.getSingleResult();
			Ars_reservas_usuDto usuarioDto = new Ars_reservas_usuDto();
	//	SalasDto rolDto = new SalasDto();
		BeanUtils.copyProperties(usuarioEntity, usuarioDto);
	//	BeanUtils.copyProperties(usuarioEntity.getRol(), rolDto);
	//	usuarioDto.setRol(rolDto);
		
		return usuarioDto;
	}

	@Override
	@Transactional
	public void saveUsuario(Ars_reservas_usuDto usuarioDto) {
		Ars_reservas_usuEntity ars_reservas_usuEntity = new Ars_reservas_usuEntity();
	//	SalasEntity rolEntity = new SalasEntity();		
	//	BeanUtils.copyProperties(usuarioDto.getRol(),rolEntity);
		BeanUtils.copyProperties(usuarioDto, ars_reservas_usuEntity);	
		//usuarioEntity.setRol(rolEntity);
		
		this.entityManager.persist(ars_reservas_usuEntity);
		
	}
	
	@Override
	@Transactional
	public void deleteUsuario(String username) {
		this.entityManager.remove(this.findByUsuario(username));		
	}	
	

	@Override
	public List<Ars_reservas_usuDto> getUsuarios() {
			Query q = entityManager.createQuery(
					"SELECT e FROM Ars_reservas_usuEntity e"
				//	+ ", RolEntity r WHERE r.id = :rol_id and r.id = e.rol.id"
					);
		//	q.setParameter("rol_id", rol_id);
			
			List<Ars_reservas_usuEntity> listArs_reservas_usuEntity = q.getResultList();
			List<Ars_reservas_usuDto> listUsuarioDto = new ArrayList<Ars_reservas_usuDto>();
			for (Ars_reservas_usuEntity usuarioEntity : listArs_reservas_usuEntity) {
				Ars_reservas_usuDto usuarioDto = new Ars_reservas_usuDto();
				BeanUtils.copyProperties(usuarioEntity, usuarioDto);
				usuarioDto.setPk_id_usuario(usuarioEntity.getPk_id_usuario());
				listUsuarioDto.add(usuarioDto);
			}
			return listUsuarioDto;
	}

	@Override
	@Transactional
	public void borrarUsuario(Long idUsuario) {
		Query q = entityManager.createQuery(
				"delete from Ars_reservas_usuEntity f where f.pk_id_usuario = :id");
		 q.setParameter("id", idUsuario);
		 Query qu = entityManager.createQuery("delete from Ars_reservasEntity r where r.usuario_id ="+idUsuario);
			int i=qu.executeUpdate();
			i=q.executeUpdate();
		
	}

	@Override
	public List<Ars_reservas_usuDto> getUsuariosId(Long idl) {
		Query q = entityManager.createQuery(
				"SELECT u FROM Ars_reservas_usuEntity u where u.pk_id_usuario ="+idl);
		List<Ars_reservas_usuEntity> listArs_reservas_usuEntity = q.getResultList();
		List<Ars_reservas_usuDto> listArs_reservas_usuDto = new ArrayList<Ars_reservas_usuDto>();
		for (Ars_reservas_usuEntity ars_reservas_usuEntity : listArs_reservas_usuEntity) {
			Ars_reservas_usuDto ars_reservas_usuDto = new Ars_reservas_usuDto();
			BeanUtils.copyProperties(ars_reservas_usuEntity, ars_reservas_usuDto);
			ars_reservas_usuDto.setPk_id_usuario(ars_reservas_usuEntity.getPk_id_usuario());
			listArs_reservas_usuDto.add(ars_reservas_usuDto);
		}
		 
		return listArs_reservas_usuDto;
	}
	
	//idusuario

	@Override
	@Transactional
	public void modificarUsuario(Long idl, String usuario, String apellidos, String email) {
		Query qu = entityManager.createQuery(
				"update Ars_reservas_usuEntity u set u.var_nombre_usuario ='"+usuario+"' ,u.var_apellidos_usuario ='"+apellidos+"',u.var_email_usuario ='"+email+"' where u.pk_id_usuario ="+idl);
		
		int i=qu.executeUpdate();
		
	}

}
