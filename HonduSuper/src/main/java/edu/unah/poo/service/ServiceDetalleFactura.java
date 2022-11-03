package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.DetalleFactura;
import edu.unah.poo.model.IdDetalleFactura;
import edu.unah.poo.repository.RepositoryDetalleFactura;

@Service
public class ServiceDetalleFactura {
	@Autowired
	RepositoryDetalleFactura repositoryDetalleFactura;
	
	public void crearDetalleFactura(DetalleFactura detalleFactura) {
		this.repositoryDetalleFactura.save(detalleFactura);
	}
	
	public DetalleFactura buscarDetalleFactura(IdDetalleFactura idDetalleFactura) {
		return this.repositoryDetalleFactura.getOne(idDetalleFactura);	
	}
	
	public List<DetalleFactura> obtenerTodosDetalleFactura(){
		return this.repositoryDetalleFactura.findAll();
	}

}
