package fr.insee.sndio.formation.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.insee.sndio.formation.springmvc.model.Application;
import fr.insee.sndio.formation.springmvc.service.ApplicationService;

@Controller
@RequestMapping("applications")
public class ApplicationController {
	
	@Autowired
	private ApplicationService applicationService;

	@GetMapping
	public String listerApplications(Model model) {
		model.addAttribute("nombreApplications", applicationService.listerApplications().size());
		return "applications";
	}
	
	@GetMapping("tableau")
	public String getTableauApplications(Model model) {
		List<Application> applications = applicationService.listerApplications();
		// ajouter le nombre d'applis dans le model
		model.addAttribute("nombreApplications", applications.size());
		model.addAttribute("listeApplications", applications);
		return "tableau";
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