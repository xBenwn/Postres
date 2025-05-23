package com.BenjaminDiaz.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.BenjaminDiaz.modelos.Postre;
import com.BenjaminDiaz.modelos.Usuario;
import com.BenjaminDiaz.servicios.ServicioPostres;
import com.BenjaminDiaz.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorPostres {
	@Autowired
	private final ServicioPostres servicioPostres;
	private final ServicioUsuarios servicioUsuarios;

	public ControladorPostres(ServicioPostres servicioPostres, ServicioUsuarios servicioUsuarios) {
		this.servicioPostres = servicioPostres;
		this.servicioUsuarios = servicioUsuarios;
	}
	
	@GetMapping("/postres")
	public String postres(Model modelo, HttpSession sesion) {
		if(sesion.getAttribute("nombre") == null) {
			return "redirect:/login";
		}
		List<Postre> listaDePostres = this.servicioPostres.obtenerTodosLosPostres();
		modelo.addAttribute("listaDePostres", listaDePostres);
		return "postres.jsp";
	}
	
	@GetMapping("/misPostres/{idUsuario}")
	public String misPostres(@PathVariable("idUsuario") Long idUsuario, Model modelo, HttpSession sesion) {
		if(sesion.getAttribute("nombre") == null) {
			return "redirect:/login";
		}
		List<Postre> listaDePostres = this.servicioPostres.obtenerTodosLosPostresPorUsuario(idUsuario);
		modelo.addAttribute("listaDePostres", listaDePostres);
		return "misPostres.jsp";
	}
	
	@GetMapping("/detalle/postre/{idPostre}")
	public String detallePostre(@PathVariable("idPostre") Long idPostre,
							  Model modelo,
							  HttpSession sesion) {
		if(sesion.getAttribute("id_usuario") == null) {
			return "redirect:/login";
		}
		Postre postre= this.servicioPostres.obtenerPorId(idPostre);
		modelo.addAttribute("postre", postre);
		return "detallePostre.jsp";
	}
	
	@GetMapping("/agregar/postres")
	public String agregarPostre(@ModelAttribute("postre") Postre postre, HttpSession sesion) {
		if(sesion.getAttribute("nombre") == null) {
			return "redirect:/login";
		}
		return "agregarPostre.jsp";
	}
	
	@GetMapping("editar/postre/{idPostre}")
	public String editarPostre(@ModelAttribute("postre") Postre editarPostre, Model modelo, HttpSession sesion, @PathVariable("idPostre") Long idPostre) {
		if(sesion.getAttribute("nombre") == null) {
			return "redirect:/login";
		}
		Postre postre = servicioPostres.obtenerPorId(idPostre);
		modelo.addAttribute("postre", postre);
		return "editarPostres.jsp";
	}
	
	@PostMapping("/procesar/agregar/postre")
	public String procesarAgregarPostre(@Valid @ModelAttribute("postre") Postre postre, BindingResult validacion, HttpSession sesion) {
		if(validacion.hasErrors()) {
			return "agregarPostre.jsp";
		}
		Long idUsuario = (Long) sesion.getAttribute("id_usuario");
		Usuario usuarioExistente = this.servicioUsuarios.obtenerUsuarioPorId(idUsuario);
		postre.setUsuario(usuarioExistente);
		this.servicioPostres.agregarPostre(postre);
		return "redirect:/postres";
	}
	
	@DeleteMapping("/eliminar/postre/{idPostre}")
	public String eliminarPostre(@PathVariable("idPostre") Long idPostre) {
		this.servicioPostres.eliminarPostre(idPostre);
		return "redirect:/postres";
	}
	
	@PutMapping("/editar/postre/{idPostre}")
	public String editarPostre(@Valid @ModelAttribute("postre") Postre postre,
							 BindingResult validacion,
							 @PathVariable("idPostre") Long idPostre, HttpSession sesion) {
		if(validacion.hasErrors()) {
			return "editarPostres.jsp";
		}
		Long idUsuario = (Long) sesion.getAttribute("id_usuario");
	    Usuario usuario = this.servicioUsuarios.obtenerUsuarioPorId(idUsuario);
		
		Postre postreActual = this.servicioPostres.obtenerPorId(idPostre);
		postre.setId(postreActual.getId());
		postre.setUsuario(usuario);
		
		this.servicioPostres.editarPostre(postre);
		return "redirect:/postres";
	}
}
