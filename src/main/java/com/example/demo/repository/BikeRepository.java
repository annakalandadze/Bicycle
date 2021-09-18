package com.example.demo.repository;

import com.example.demo.entity.Bicycle;
import com.example.demo.entity.Gear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BikeRepository extends JpaRepository<Bicycle, Long> {
    Optional<Bicycle> findById(Long id);
}
