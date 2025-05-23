package com.BenjaminDiaz.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BenjaminDiaz.modelos.Postre;

@Repository
public interface RepositorioPostres  extends CrudRepository<Postre, Long>{
	List<Postre> findAll();
	List<Postre> findAllByUsuarioId(Long idUsuario);
	void deleteById(Long idPostre);
}
