package it.dstech.formazione.service;

import it.dstech.formazione.models.Utente;

public interface UtenteServiceDAO {

	
	Utente save(Utente utente);
	
	void delete(Utente utente);
	
	Utente findById(long id);
	
	Utente findByUsername(String username);
	
	
}
