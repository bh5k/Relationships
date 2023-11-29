package com.barclay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
    private Long id;
    private String nickname;
    private HumanDto human;

    public PetDto(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
