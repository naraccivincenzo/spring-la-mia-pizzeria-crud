package org.lessons.booleaners.springlamiapizzeriacrud.repo;

import org.lessons.booleaners.springlamiapizzeriacrud.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
