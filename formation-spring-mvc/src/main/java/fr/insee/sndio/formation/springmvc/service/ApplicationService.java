package fr.insee.sndio.formation.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.insee.sndio.formation.springmvc.model.Application;
import fr.insee.sndio.formation.springmvc.repository.ApplicationRepository;

@Service
public class ApplicationService {

	public ApplicationService() {		
		listeApplications.add(new Application(1L, "N4DS", "Transformation des fichiers 4DS en DADS-U"));
		listeApplications.add(new Application(2L, "Ecmoss", "Gestion de l'enquête ECMOSS"));
		listeApplications.add(new Application(3L, "Geoloc", "Géolocalisation d'adresses"));
	}

	private List<Application> listeApplications = new ArrayList<>();
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	public List<Application> listerApplications() {
		return applicationRepository.findAll();
	}
	
	public List<Application> majApplications(Application application) {
		listeApplications.stream()
		.filter(appli -> appli.getId().equals(application.getId()))
		.findFirst()
		.ifPresentOrElse(appli -> {
					appli.setNom(application.getNom());
					appli.setDescription(application.getDescription());
		}, 
		() -> listeApplications.add(application));
		
		return listeApplications;
	}

	public List<Application> getListeApplications() {
		return listeApplications;
	}

	public void setListeApplications(List<Application> listeApplications) {
		this.listeApplications = listeApplications;
	}
	
}
