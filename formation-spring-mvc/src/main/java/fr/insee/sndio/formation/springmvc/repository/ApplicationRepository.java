package fr.insee.sndio.formation.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insee.sndio.formation.springmvc.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
