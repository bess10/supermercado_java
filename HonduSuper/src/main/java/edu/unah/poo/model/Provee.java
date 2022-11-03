package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="provee")
@IdClass(IdProvee.class)
public class Provee implements Serializable{
	@Id
	private int idProducto;
	@Id
	private int idProveedor;
	
	@ManyToOne
	@JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
	@JsonBackReference
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor", insertable = false, updatable = false)
	@JsonBackReference
	private Proveedor proveedor;

	public Provee() {
	}

	public Provee(int idProducto, int idProveedor, Producto producto, Proveedor proveedor) {
		super();
		this.idProducto = idProducto;
		this.idProveedor = idProveedor;
		this.producto = producto;
		this.proveedor = proveedor;
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
	
	public void nuevoPedido(Producto producto, Proveedor proveedor) {
		if(producto.getExistencia()<4) {
			System.out.println("realizar nuevo pedido del producto");	
		}
	}
	
	
	

}
