package fr.insee.sndio.formation.springmvc.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.insee.sndio.formation.springmvc.model.Application;
import fr.insee.sndio.formation.springmvc.service.ApplicationService;

@Controller
@RequestMapping("applications")
public class ApplicationController {
	

	@Autowired
	private ApplicationService applicationService;
	
	@GetMapping("{toto}")
	public String listerApplications(@RequestParam String desc, @PathVariable String toto, Model model) {
		List<Application> listeApplications = applicationService
				.listerApplications()
				.stream()
				.filter(appli -> appli.getDescription().contains(desc))
				.collect(Collectors.toList());
		model.addAttribute("listeApplications", listeApplications);
		return "applications";
	}

	@GetMapping
	public String prepareFormulaire(Model model) {
		model.addAttribute("application", new Application());
		return "formulaire";
	}
	
	@PostMapping("enregistrer")
	public String enregistrer(Application application, RedirectAttributes redirectAttributes) {	
		// traitement métier, peu importe
		List<Application> listeApplications = applicationService.listerApplications();
		listeApplications.add(application);
		
//		 FlashAttributes dispo pour la vue qui reprend la main 
		redirectAttributes.addFlashAttribute("comptage", listeApplications.size());
		redirectAttributes.addFlashAttribute("message", "Application enregistrée");
		return "redirect:/applications";
	 }
	
	@PostMapping("update")
	public String enregister(Application application, Model model) {		
		List<Application> listeApplications = applicationService.majApplications(application);
		model.addAttribute("listeApplications", listeApplications);
		return "applications";
	}
	
	
	
	
	
}