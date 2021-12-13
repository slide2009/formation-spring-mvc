package fr.insee.sndio.formation.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.insee.sndio.formation.springmvc.service.ApplicationService;

@Controller
@RequestMapping("applications")
public class ApplicationController {
	
	@Autowired
	private ApplicationService applicationService;

	@GetMapping("tableau")
	public String listerApplications() {
		applicationService.listerApplications().forEach(app -> System.out.println(app.getNom()));
		return "applications";
	}
	
	@GetMapping("{id}/{nom}")
	public String getApplications(@PathVariable Long id, @PathVariable String nom) {
		System.out.println("Id = " + id);
		System.out.println("Nom = " + nom);
		return "applications";
	}

	@GetMapping("filtres")
	public String filtrerApplications(@RequestParam String nom, 
		@RequestParam Long id) {
		System.out.println(nom);
		System.out.println(id);
		return "applications";
	}
}