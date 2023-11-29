package com.barclay.controller;

import com.barclay.dto.HumanDto;
import com.barclay.model.Human;
import com.barclay.repository.HumanRepository;
import com.barclay.util.HumanDtoConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@Data
@Slf4j
public class HumanController {

    private final HumanRepository humanRepository;

    @GetMapping("/humans")
    public List<Human> getAllHumans() {
        List<Human> humans = new ArrayList<>();
        humanRepository.findAll().forEach(humans::add);
        return humans;
    }

    @PostMapping("/human")
    public Human createHuman(@RequestBody Human human) {
        log.debug("In the createHuman method");
        log.debug(String.valueOf(human));
        return humanRepository.save(human);
    }

    @GetMapping("/human/{id}")
    public HumanDto getById(@PathVariable("id") Long id) {
        Human human = humanRepository.findById(id).orElseGet(Human::new);
        return HumanDtoConverter.convert(human);
    }
}
