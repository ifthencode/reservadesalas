package com.reserva.salas.service;

import com.reserva.salas.dto.UsuarioDto;

public interface UsuarioService {

	UsuarioDto findByName(String nombre);
}
