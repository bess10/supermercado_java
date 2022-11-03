package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdDetalleFactura implements Serializable{
	private int idProducto;
	private int idFactura;
	
	public IdDetalleFactura() {
	}

	public IdDetalleFactura(int idProducto, int idFactura) {
		super();
		this.idProducto = idProducto;
		this.idFactura = idFactura;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdDetalleFactura) {
			IdDetalleFactura tmp=(IdDetalleFactura)obj;
			if(this.idProducto == tmp.getIdProducto() && this.idFactura == tmp.getIdFactura()) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}
	
	public int hashCode() {
		return this.idProducto+this.idFactura;
	}
	

}
