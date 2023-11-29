package com.barclay.controller;

import com.barclay.dto.PetDto;
import com.barclay.model.Human;
import com.barclay.model.Pet;
import com.barclay.repository.PetRepository;
import com.barclay.util.PetDtoConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class PetController {

    private final PetRepository petRepository;

    @PostMapping("/pet")
    public Pet createPet(@RequestBody Pet pet) {
        log.debug("In create");
        log.debug(String.valueOf(pet));
        return petRepository.save(pet);
    }

    @GetMapping("/pets")
    public List<Pet> getAll() {
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @GetMapping("/pet/{id}")
    public PetDto getById(@PathVariable("id") Long id) {
        Pet pet = petRepository.findById(id).orElseGet(Pet::new);
        return PetDtoConverter.convert(pet);
    }

    @PutMapping("/pet")
    public Pet updatePet(@RequestBody Pet pet) {
        log.debug("In update");
        log.debug(String.valueOf(pet));
        return petRepository.save(pet);
    }
}
