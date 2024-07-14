package com.springlessons.catalog.rest.task01.repository;

import com.springlessons.catalog.rest.task01.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
