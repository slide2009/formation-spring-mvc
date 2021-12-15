package fr.insee.sndio.formation.springmvc.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insee.sndio.formation.springmvc.model.Application;
import fr.insee.sndio.formation.springmvc.service.ApplicationService;

@RestController
@RequestMapping("applications-api")
public class ApplicationRestController {

	@Autowired
	private ApplicationService applicationService;
	
	@GetMapping
	public List<Application> listerApplications() {		
		return applicationService.listerApplications();
	}
	
	@DeleteMapping("{idApplication}")
	public List<Application> delete(@PathVariable Long idApplication) {
		List<Application> listeModif = applicationService.listerApplications().stream()
				.filter(appli -> !appli.getId().equals(idApplication))
				.collect(Collectors.toList());
		applicationService.setListeApplications(listeModif);
		return listeModif;
	}
}