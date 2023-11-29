package com.barclay;

import com.barclay.dto.PetDto;
import com.barclay.model.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RelationshipsApplicationTests {


	@Test
	void testGet() {
		RestTemplate restTemplate = new RestTemplate();
		PetDto pet = restTemplate.getForObject("http://localhost:8080/pet/1", PetDto.class);
		assertNotNull(pet);
		System.out.println(pet.getNickname());
		System.out.println(pet.getHuman().getName());
	}

	@Test
	void testPut() throws JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		PetDto pet = restTemplate.getForObject("http://localhost:8080/pet/1", PetDto.class);

		pet.getHuman().setName("Bryan Hansen");
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(pet);
		System.out.println(str);

		restTemplate.put("http://localhost:8080/pet", pet);

		assertTrue(true);
	}

}
