package com.reserva.salas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reserva.salas.dao.UsuarioDao;
import com.reserva.salas.dto.UsuarioDto;
import com.reserva.salas.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	/*
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	 */
	 
	@Override
	public UsuarioDto findByName(String nombre) {
		// TODO Auto-generated method stub
		return null; //alumnoDao.findByName(nombre);
	}
	
	
	  public void saveUser(UsuarioDto usuarioDto) {
	  //usuarioDto.setPassword(bCryptPasswordEncoder.encode(usuarioDto.getPassword()) ); 
	  this.usuarioDao.saveUsuario(usuarioDto); }
	 
	
	public void deleteUsuario(String username){
		this.usuarioDao.deleteUsuario(username);
	}
	
	
	public List<UsuarioDto> getUsuarios(){
		return this.usuarioDao.getUsuarios();
	}
	
	

}
