package it.dstech.formazione.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.dstech.formazione.models.Ruolo;
import it.dstech.formazione.models.Utente;
import it.dstech.formazione.repositories.RuoloRepository;
import it.dstech.formazione.repositories.UtenteRepository;

@Service
public class UtenteServiceDAOImpl implements UtenteServiceDAO{

	private UtenteRepository utenteRepo;
	private RuoloRepository ruoloRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UtenteServiceDAOImpl(UtenteRepository utenteRepo, RuoloRepository ruoloRepo,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.utenteRepo = utenteRepo;
		this.ruoloRepo = ruoloRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public Utente save(Utente utente) {
		utente.setPassword(bCryptPasswordEncoder.encode(utente.getPassword()));
		utente.setActive(true);
		Ruolo ruolo = ruoloRepo.findByRuolo("ADMIN");
		utente.setRuoli(new HashSet<Ruolo>(Arrays.asList(ruolo)));
		return utenteRepo.save(utente);
		
	}

	

	@Override
	public void delete(Utente utente) {
		utenteRepo.delete(utente);
		
	}

	@Override
	public Utente findById(long id) {
		return utenteRepo.findById(id).get();
		
	}

	@Override
	public Utente findByUsername(String username) {
		
		return utenteRepo.findByUsername(username);
	}

}
