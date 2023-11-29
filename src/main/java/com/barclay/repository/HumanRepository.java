package com.barclay.repository;

import com.barclay.model.Human;
import org.springframework.data.repository.CrudRepository;

public interface HumanRepository extends CrudRepository<Human, Long> {
}
