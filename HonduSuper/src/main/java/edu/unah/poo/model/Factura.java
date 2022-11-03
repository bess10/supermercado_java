package edu.unah.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
@Table(name="factura")
public class Factura implements Serializable{
	@Id
	private int idFactura;
	private LocalDate fecha;
	private double total;
	
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	@JsonBackReference
	private Cliente cliente;
	
	public Factura() {
	}

	public Factura(int idFactura, LocalDate fecha, double total, Cliente cliente) {
		super();
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

}
