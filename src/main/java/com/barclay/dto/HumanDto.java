package com.barclay.dto;

import com.barclay.model.Pet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HumanDto {

    private Long id;
    private String name;
    @JsonIgnore
    private List<Pet> pets;

    public HumanDto () {

    }

    public HumanDto (Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
