package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdProvee implements Serializable{
	private int idProducto;
	private int idProveedor;
	
	public IdProvee() {
	
	}
	
	public IdProvee(int idProducto, int idProveedor) {
		super();
		this.idProducto = idProducto;
		this.idProveedor = idProveedor;
	}
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdProvee) {
			IdProvee tmp=(IdProvee)obj;
			if(this.idProducto == tmp.getIdProducto() && this.idProveedor == tmp.getIdProveedor()) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}
	
	public int hashCode() {
		return this.idProducto+this.idProveedor;
	}

}
