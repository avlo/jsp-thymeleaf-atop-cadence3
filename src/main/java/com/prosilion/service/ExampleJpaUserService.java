package com.prosilion.service;

import com.prosilion.model.dto.ExampleJpaUserDto;
import com.prosilion.model.entity.ExampleJpaUser;
import com.prosilion.repository.ExampleJpaUserRepository;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Service
public class ExampleJpaUserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleJpaUserService.class);
	private final ExampleJpaUserRepository exampleJpaUserRepository;

	@Autowired
	public ExampleJpaUserService(ExampleJpaUserRepository exampleJpaUserRepository) {
		this.exampleJpaUserRepository = exampleJpaUserRepository;
	}

	public ExampleJpaUser findById(Long id) {
		return exampleJpaUserRepository.findById(id).get();
	}

	private ExampleJpaUser find(@NonNull ExampleJpaUser exampleJpaUser) {
		return Objects.isNull(exampleJpaUser.getId()) ? exampleJpaUser : findById(exampleJpaUser.getId());
	}

	// TODO: can repurpose below to use AppUserService instead?
//	@Transactional
	public ExampleJpaUserDto update(@NonNull ExampleJpaUserDto exampleJpaUserDto) throws InvocationTargetException, IllegalAccessException {
		LOGGER.info("EXAMPLE USER - updating");
		ExampleJpaUser exampleJpaUser = exampleJpaUserDto.convertToExampleUser();
		ExampleJpaUser retrievedUser = find(exampleJpaUser);
		LOGGER.info("Confirm retrieved existing exampleJpaUser [{}]", retrievedUser);
		ExampleJpaUser returnUser = exampleJpaUserRepository.save(exampleJpaUser);
		LOGGER.info("Updating exampleJpaUser [{}]", returnUser);
		return exampleJpaUserRepository.findById(exampleJpaUser.getId()).get().convertToDto();
	}
}
