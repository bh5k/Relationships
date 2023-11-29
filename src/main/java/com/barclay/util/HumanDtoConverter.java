package com.barclay.util;

import com.barclay.dto.HumanDto;
import com.barclay.model.Human;

public class HumanDtoConverter {

    public static HumanDto convert(Human human) {
        return new HumanDto(human.getId(), human.getName(), human.getPets());
    }

    public static HumanDto convertWithoutPets(Human human) {
        return new HumanDto(human.getId(), human.getName());
    }
}
