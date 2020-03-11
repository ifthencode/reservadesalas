package com.reserva.services;

import com.reserva.dtos.UsuarioDto;

public interface UsuarioService {

	UsuarioDto findByName(String nombre);
}
