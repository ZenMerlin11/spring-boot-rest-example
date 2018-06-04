package io.github.zenmerlin11.coffeerun.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {}
