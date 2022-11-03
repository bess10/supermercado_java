package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.DetalleFactura;
import edu.unah.poo.model.IdDetalleFactura;

public interface RepositoryDetalleFactura extends JpaRepository<DetalleFactura, IdDetalleFactura>{

}
