package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.IdProvee;
import edu.unah.poo.model.Provee;

public interface RepositoryProvee extends JpaRepository<Provee, IdProvee>{

}
