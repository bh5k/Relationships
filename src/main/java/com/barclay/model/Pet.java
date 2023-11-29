package com.barclay.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "human_id")
    @JsonBackReference
    private Human human;
}
