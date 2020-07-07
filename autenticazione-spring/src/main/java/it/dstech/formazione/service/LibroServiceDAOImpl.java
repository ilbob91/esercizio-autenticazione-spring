package it.dstech.formazione.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.formazione.models.Libro;
import it.dstech.formazione.repositories.LibroRepository;

@Service
public class LibroServiceDAOImpl implements LibroServiceDAO {
	@Autowired
	private LibroRepository libroRepository;

	@Override
	public Libro save(Libro libro) {

		return libroRepository.save(libro);
	}

	@Override
	public void delete(Libro libro) {
		libroRepository.delete(libro);

	}

	@Override
	public Libro findById(long id) {

		return libroRepository.findById(id).get();
	}

	@Override
	public List<Libro> findAll() {

		return libroRepository.findAll();
	}

}
