package fr.insee.sndio.formation.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FormationSpringMvcApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(FormationSpringMvcApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/tableau-ajax").setViewName("tableau-ajax");
		// on peut rajouter autant du vues qu'on veut ici
	}
	
	
}
