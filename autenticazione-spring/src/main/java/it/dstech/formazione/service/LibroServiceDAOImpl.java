package it.dstech.formazione.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.formazione.models.Libro;
@Service
public class LibroServiceDAOImpl implements LibroServiceDAO {
@Autowired
private LibroServiceDAO libroService;

@Override
public Libro save(Libro libro) {
	
	return libroService.save(libro);
}

@Override
public void delete(Libro libro) {
	libroService.delete(libro);
	
}

@Override
public Libro findById(long id) {
	
	return libroService.findById(id);
}

@Override
public List<Libro> findAll() {
	
	return libroService.findAll();
}



}
