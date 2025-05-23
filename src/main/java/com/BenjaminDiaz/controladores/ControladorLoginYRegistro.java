package com.BenjaminDiaz.controladores;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.BenjaminDiaz.modelos.Login;
import com.BenjaminDiaz.modelos.Usuario;
import com.BenjaminDiaz.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorLoginYRegistro {
	@Autowired
	private final ServicioUsuarios servicioUsuarios;

	public ControladorLoginYRegistro(ServicioUsuarios servicioUsuarios) {
		this.servicioUsuarios = servicioUsuarios;
	}
	
	@GetMapping("/registro")
	public String registro(@ModelAttribute("registro") Usuario usuario) {
		return "registro.jsp";
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("login") Login usuarioLogin) {
		return "login.jsp";
	}
	
	@PostMapping("/procesar/registro")
	public String procesarRegistro(@Valid @ModelAttribute("registro") Usuario nuevoUsuario, BindingResult validacion, HttpSession sesion) {
		Usuario usuarioExistente = this.servicioUsuarios.obtenerUsuarioPorCorreo(nuevoUsuario.getCorreo());
		if(usuarioExistente != null) {
			validacion.rejectValue("correo", "correoExistente", "Este correo ya está en uso.");
		}
		if (! nuevoUsuario.getContrasena().equals(nuevoUsuario.getConfirmarContraseña())) {
			validacion.rejectValue("confirmarContraseña", "contraseñasDistintas", "Las contraseñas no son iguales.");
		}
		if (validacion.hasErrors()) {
			return "registro.jsp";
		}
		String contrasenaEncriptada = BCrypt.hashpw(nuevoUsuario.getContrasena(), BCrypt.gensalt());
		nuevoUsuario.setContrasena(contrasenaEncriptada);
		Usuario usuarioActual = this.servicioUsuarios.agregarUsuario(nuevoUsuario);
	
		sesion.setAttribute("id_usuario", usuarioActual.getId());
		sesion.setAttribute("nombre", usuarioActual.getNombre());
		sesion.setAttribute("apellido", usuarioActual.getApellido());
		return "redirect:/postres";
	}
	
	@PostMapping("/procesar/login")
	public String procesarLogin(@Valid @ModelAttribute("login") Login loginUsuario,
	                            BindingResult validacion,
	                            HttpSession sesion) {

	    if (validacion.hasErrors()) {
	        return "login.jsp";
	    }

	    Usuario usuarioActual = this.servicioUsuarios.obtenerUsuarioPorCorreo(loginUsuario.getCorreo());
	    
	    if (usuarioActual == null) {
	        validacion.rejectValue("correo", "correoNoExistente", "Por favor, ingrese un correo existente.");
	        return "login.jsp";
	    }

	    if (!BCrypt.checkpw(loginUsuario.getContrasena(), usuarioActual.getContrasena())) {
	        validacion.rejectValue("contrasena", "credencialIncorrecta", "Credenciales Incorrectas.");
	        return "login.jsp";
	    }
	    


	    sesion.setAttribute("id_usuario", usuarioActual.getId());
	    sesion.setAttribute("nombre", usuarioActual.getNombre());
	    sesion.setAttribute("apellido", usuarioActual.getApellido());

	    return "redirect:/postres";
	}
	
	@PostMapping("/cerrar/sesion")
	public String cerrarSesion(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/login";
	}
}
