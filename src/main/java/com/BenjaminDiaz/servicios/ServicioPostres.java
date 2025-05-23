package com.BenjaminDiaz.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BenjaminDiaz.modelos.Postre;
import com.BenjaminDiaz.repositorios.RepositorioPostres;

@Service
public class ServicioPostres {
	@Autowired
	private final RepositorioPostres repositorioPostres;

	public ServicioPostres(RepositorioPostres repositorioPostres) {
		this.repositorioPostres = repositorioPostres;
	}
	
	public List<Postre> obtenerTodosLosPostres() {
		return this.repositorioPostres.findAll();
	}
	
	public List<Postre> obtenerTodosLosPostresPorUsuario(Long idUsuario) {
		return this.repositorioPostres.findAllByUsuarioId(idUsuario);
	}
	
	public Postre agregarPostre(Postre nuevoPostre) {
		return this.repositorioPostres.save(nuevoPostre);
	}
	
	public Postre obtenerPorId(Long idPostre) {
		return this.repositorioPostres.findById(idPostre).orElse(null);
	}
	
	public Postre editarPostre(Postre postre) {
		return this.repositorioPostres.save(postre);
	}
	
	public void eliminarPostre(Long id) {
		this.repositorioPostres.deleteById(id);
	}
	
}
