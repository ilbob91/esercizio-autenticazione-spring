package it.dstech.formazione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dstech.formazione.models.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
