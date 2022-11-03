package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//esta clase se creo solo con la finalidad de implementar el security del proyecto
@Entity
@Table(name="empleado")
public class Empleado implements Serializable {

	@Id
	private int idEmpleado;
	private String nombre;
	private String usuario;
	private String contrasenia;
	private String rol;

	public Empleado() {
	}

	public Empleado(int idEmpleado, String nombre, String usuario, String contrasenia, String rol) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.rol = rol;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
