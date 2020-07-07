package it.dstech.formazione.service;

import java.util.List;

import it.dstech.formazione.models.Libro;

public interface LibroServiceDAO {

	Libro save(Libro libro);
	
	void delete(Libro libro);
	
	Libro findById(long id);
	
	List<Libro> findAll();
	
}
