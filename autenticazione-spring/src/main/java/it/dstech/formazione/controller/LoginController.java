package it.dstech.formazione.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.dstech.formazione.models.Libro;
import it.dstech.formazione.models.Utente;
import it.dstech.formazione.service.LibroServiceDAO;
import it.dstech.formazione.service.UtenteServiceDAO;

@Controller
public class LoginController {

	@Autowired
	private UtenteServiceDAO userService;
	@Autowired
	private LibroServiceDAO libroService;

	@GetMapping(value = { "/", "/index" })
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listaLibri", libroService.findAll());
		modelAndView.setViewName("index");
		return modelAndView;

	}

	@GetMapping(value = "/registrazione")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Utente user = new Utente();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registrazione");
		return modelAndView;
	}

	@PostMapping(value = "/registrazione")
	public ModelAndView createNewUser(Utente user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Utente userExists = userService.findByUsername(user.getUserName());
		if (userExists != null) {
			bindingResult.rejectValue("user_name", "error.user",
					"There is already a user registered with the user name provided");

		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registrazione");
		} else {
			userService.save(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("listaLibri", libroService.findAll());
			modelAndView.setViewName("index");
		}
		return modelAndView;

	}

	@GetMapping(value = "/admin/home")

	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente user = userService.findByUsername(auth.getName());
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;

	}

	@GetMapping(value = "/admin/new_libro")
	public ModelAndView newLibro() {
		ModelAndView modelAndView = new ModelAndView();
		Libro libro = new Libro();
		modelAndView.addObject("libro", libro);
		modelAndView.setViewName("nuovo_libro");
		return modelAndView;
	}

	@PostMapping(value = "/admin/aggiungi")
	public ModelAndView aggiungiLibro(Libro libro, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		libroService.save(libro);
		modelAndView.addObject("messaggio", "book has been registered successfully");
		modelAndView.addObject("listaLibri", libroService.findAll());
		modelAndView.setViewName("index");
		return modelAndView;

	}
}
