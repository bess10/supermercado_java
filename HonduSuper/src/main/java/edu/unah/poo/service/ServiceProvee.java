package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.IdProvee;
import edu.unah.poo.model.Provee;
import edu.unah.poo.model.Proveedor;
import edu.unah.poo.repository.RepositoryProvee;
import edu.unah.poo.repository.RepositoryProveedor;

@Service
public class ServiceProvee {
	@Autowired
	RepositoryProvee repositoryProvee;
	
	public void crearProvee(Provee provee) {
		this.repositoryProvee.save(provee);
	}
	
	public Provee buscarProvee(IdProvee idProvee) {
		return this.repositoryProvee.getOne(idProvee);	
	}
	
	public List<Provee> obtenerTodosProvee(){
		return this.repositoryProvee.findAll();
	}

}
