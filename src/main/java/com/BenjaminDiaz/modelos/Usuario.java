package com.BenjaminDiaz.modelos;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Por favor, proporciona tu nombre.")
	@Size(min=3, message = "Por favor, proporciona un nombre más largo.")
	private String nombre;
	
	@NotBlank(message = "Por favor, proporciona tu apellido.")
	@Size(min=3, message = "Por favor, proporciona un apellido más largo.")
	private String apellido;
	
	@NotBlank(message = "Por favor, proporciona tu correo.")
	@Email(message = "Por favor, proporciona un correo válido.")
	private String correo;
	
	@NotBlank(message = "Por favor, proporciona tu contraseña.")
	@Size(min=8, message = "Tu contraseña necesita tener al menos 8 caracteres.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", 
				message = "La contraseña necesita incluir al menos una letra mayúscula, una letra minúscula y un número")
	private String contrasena;
	
	@Transient
	private String confirmarContraseña;
	
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	List<Postre> postres;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;
	
	public Usuario() {}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



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



	public String getConfirmarContraseña() {
		return confirmarContraseña;
	}



	public void setConfirmarContraseña(String confirmarContraseña) {
		this.confirmarContraseña = confirmarContraseña;
	}



	public List<Postre> getPostres() {
		return postres;
	}



	public void setPostres(List<Postre> postres) {
		this.postres = postres;
	}



	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}



	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}



	@PrePersist
	   protected void onCreate() {
	       this.fechaCreacion = new Date();
	       this.fechaActualizacion = this.fechaCreacion;
	   }
	 @PreUpdate
	 	protected void onUpdate() {
		 	this.fechaActualizacion = new Date();
	   }
}
