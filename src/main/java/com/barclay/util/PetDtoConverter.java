package com.barclay.util;

import com.barclay.dto.PetDto;
import com.barclay.model.Pet;

public class PetDtoConverter {

    public static PetDto convert(Pet pet) {
        return new PetDto(pet.getId(),
                     pet.getNickname(),
                     HumanDtoConverter.convertWithoutPets(pet.getHuman()));
    }

    public static PetDto convertWithoutHuman(Pet pet) {
        return new PetDto(pet.getId(),
                pet.getNickname());
    }
}
