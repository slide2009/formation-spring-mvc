package fr.insee.sndio.formation.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import fr.insee.sndio.formation.springmvc.model.Application;

public class ApplicationService {

	public ApplicationService() {		
		listeApplications.add(new Application(1L, "N4DS", "Transformation des fichiers 4DS en DADS-U"));
		listeApplications.add(new Application(2L, "Ecmoss", "Gestion de l'enquête ECMOSS"));
		listeApplications.add(new Application(3L, "Geoloc", "Géolocalisation d'adresses"));
	}

	private List<Application> listeApplications = new ArrayList<>();
	
	public List<Application> listerApplications() {
		return listeApplications;
	}
	
	
}
