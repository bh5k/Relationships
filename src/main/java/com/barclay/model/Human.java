package com.barclay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Human {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "human_id")
    @JsonManagedReference
    private List<Pet> pets;
}
