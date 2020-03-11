package com.reserva.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reserva.daos.UsuarioDao;
import com.reserva.dtos.UsuarioDto;
import com.reserva.services.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	
	 
	@Override
	public UsuarioDto findByName(String nombre) {
		// TODO Auto-generated method stub
		return null; 
	}
	
	
	 
	
	/*
	 * public void deleteUsuario(String username){
	 * this.usuarioDao.deleteUsuario(username); }
	 */
	
	
	public List<UsuarioDto> getUsuarios(){
		return this.usuarioDao.getUsuarios();
	}




	@Override
	public void saveUsuario(UsuarioDto usuarioDto) {
		// TODO Auto-generated method stub
		this.usuarioDao.saveUsuario(usuarioDto);
	}




	@Override
	public void borrarUsuario(Long idUsuario) {
		this.usuarioDao.borrarUsuario(idUsuario);;
		
	}



	@Override
	public List<UsuarioDto> getUsuarioId(Long idl) {
		return this.usuarioDao.getUsuariosId(idl);
	}



	@Override
	public void modificarUsuario(Long idl, String usuario, String apellidos, String email) {
		this.usuarioDao.modificarUsuario(idl,usuario,apellidos,email);
		
	}
	
	

}
