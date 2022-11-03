package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable{
	@Id
	private int idProveedor;
	private String nombre;
	private String direccion;
	private String nombreContacto;
	private String telefono;
	private String correoElectronico;
	
	public Proveedor() {
	}

	public Proveedor(int idProveedor, String nombre, String direccion, String nombreContacto, String telefono,
			String correoElectronico) {
		super();
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.nombreContacto = nombreContacto;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	

}
