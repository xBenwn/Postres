package com.BenjaminDiaz.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BenjaminDiaz.modelos.Usuario;
import com.BenjaminDiaz.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	@Autowired
	private final RepositorioUsuarios repositorioUsuarios;

	public ServicioUsuarios(RepositorioUsuarios repositorioUsuarios) {
		this.repositorioUsuarios = repositorioUsuarios;
	}
	
	public Usuario agregarUsuario(Usuario nuevoUsuario) {
		return this.repositorioUsuarios.save(nuevoUsuario);
	}
	
	public Usuario obtenerUsuarioPorCorreo(String correo) {
		return this.repositorioUsuarios.findByCorreo(correo);
	}
	
	public Usuario obtenerUsuarioPorId(Long idUsuario) {
		return this.repositorioUsuarios.findById(idUsuario).orElse(null);
	}
}
