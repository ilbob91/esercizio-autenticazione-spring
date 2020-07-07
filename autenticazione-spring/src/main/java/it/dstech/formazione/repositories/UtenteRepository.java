package it.dstech.formazione.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dstech.formazione.models.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Utente findByUsername(String username);
}
