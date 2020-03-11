package com.reserva.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.reserva.daos.Ars_reservas_usuDao;
import com.reserva.dtos.Ars_reservas_usuDto;

import com.reserva.services.Ars_reservas_usuService;


@Service("Ars_reservas_usuService")
public class Ars_reservas_usuServiceImpl implements Ars_reservas_usuService{

	@Autowired
	private Ars_reservas_usuDao usuarioDao;
	
	
	 
	@Override
	public Ars_reservas_usuDto findByName(String nombre) {
		// TODO Auto-generated method stub
		return null; 
	}
	
	
	 
	
	/*
	 * public void deleteUsuario(String username){
	 * this.usuarioDao.deleteUsuario(username); }
	 */
	
	
	public List<Ars_reservas_usuDto> getUsuarios(){
		return this.usuarioDao.getUsuarios();
	}




	@Override
	public void saveUsuario(Ars_reservas_usuDto usuarioDto) {
		// TODO Auto-generated method stub
		this.usuarioDao.saveUsuario(usuarioDto);
	}




	@Override
	public void borrarUsuario(Long idUsuario) {
		this.usuarioDao.borrarUsuario(idUsuario);;
		
	}



	@Override
	public List<Ars_reservas_usuDto> getUsuarioId(Long idl) {
		return this.usuarioDao.getUsuariosId(idl);
	}



	@Override
	public void modificarUsuario(Long idl, String usuario, String apellidos, String email) {
		this.usuarioDao.modificarUsuario(idl,usuario,apellidos,email);
		
	}
	
	

}
