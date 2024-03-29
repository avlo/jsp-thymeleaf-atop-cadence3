package com.prosilion.config;

import com.prosilion.model.entity.Book;
import com.prosilion.model.entity.ExampleJpaUser;
import com.prosilion.repository.BookRepository;
import com.prosilion.repository.ExampleJpaUserRepository;
import edu.mayo.lpea.cad.cadence3.security.service.CustomizableAppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {
		ExampleJpaUserRepository.class
		, BookRepository.class
})
@EntityScan(basePackageClasses = {
		ExampleJpaUser.class,
		Book.class
})
@ComponentScan(basePackages = "edu.mayo.lpea.cad.cadence3.*")
public class ExampleJpaUserConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleJpaUserConfig.class);

	@Bean
	CustomizableAppUserService customizableAppUserService() {
		LOGGER.info("EXAMPLE USER CONFIG - Creating ExampleJpaUser");
		return new CustomizableAppUserService(new ExampleJpaUser());
	}
}
