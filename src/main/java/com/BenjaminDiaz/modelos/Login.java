package com.BenjaminDiaz.modelos;

import jakarta.validation.constraints.Email;

public class Login {
	
	@Email(message="Por favor, proporciona un correo válido.")
	private String correo;
	
	private String contrasena;
	
	public Login() {}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
