package com.example.springbackend.repository;

import com.example.springbackend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CarRepo extends JpaRepository<Car,Long> {
}
