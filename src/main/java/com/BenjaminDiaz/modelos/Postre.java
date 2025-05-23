package com.BenjaminDiaz.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="postres")
public class Postre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Por favor, proporcione un nombre.")
	@Size(min=5, message = "Por favor, proporcione un nombre mas largo.")
	private String nombre;
	
	@NotBlank(message = "Por favor, proporcione los ingredientes.")
	@Size(min=10, message = "Por favor, proporcione una lista de ingredientes mas larga.")
	private String ingredientes;
	
	@NotBlank(message = "Por favor, proporcione las instrucciones.")
	@Size(min=10, message = "Por favor, proporcione una lista de instrucciones mas larga.")
	private String instrucciones;
	
	@NotBlank(message = "Por favor, proporcione una Url valida con la imagen.")
	@Pattern(regexp="^(http(s?):\\/\\/)?(www\\.)?.+\\.(jpg|jpeg|png|gif|bmp|webp)$", message="Proporcione una URL de imagen.")
	private String urlImagen;
	
	@NotBlank(message = "Por favor, proporcione el tiempo de preparación.")
	@Pattern(regexp=".*minutos.*", message="El tiempo tiene que ser expresado en minutos.")
	private String tiempoPreparacion;
	
	@ManyToOne
	@JoinTable(name="id_usuario")
	private Usuario usuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;
	
	public Postre() {}
	
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


	public String getIngredientes() {
		return ingredientes;
	}


	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}


	public String getInstrucciones() {
		return instrucciones;
	}


	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}


	public String getUrlImagen() {
		return urlImagen;
	}


	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}


	public String getTiempoPreparacion() {
		return tiempoPreparacion;
	}


	public void setTiempoPreparacion(String tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
