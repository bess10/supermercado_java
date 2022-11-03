package edu.unah.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name="detallefactura")
@IdClass(IdDetalleFactura.class)
public class DetalleFactura implements Serializable{
	@Id
	private int idProducto;
	@Id
	private int idFactura;
	private double precio;
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
	@JsonBackReference
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "idFactura", referencedColumnName = "idFactura", insertable = false, updatable = false)
	@JsonBackReference
	private Factura factura;
	
	public DetalleFactura() {
	}

	public DetalleFactura(int idProducto, int idFactura, double precio, int cantidad, Producto producto,
			Factura factura) {
		super();
		this.idProducto = idProducto;
		this.idFactura = idFactura;
		this.precio = precio;
		this.cantidad = cantidad;
		this.producto = producto;
		this.factura = factura;
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

	public double getPrecio() {
		return this.producto.getPrecioVenta();
	}

	public void setPrecio(double precio) {
		this.precio = this.producto.getPrecioVenta();
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	
	
	
	

}
