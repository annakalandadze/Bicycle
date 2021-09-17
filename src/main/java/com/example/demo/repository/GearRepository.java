package com.example.demo.repository;

import com.example.demo.entity.Gear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface GearRepository extends JpaRepository<Gear, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Gear g SET g.gearLevel = g.gearLevel+1 WHERE g.id = ?1")
    void incrementLevel(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Gear g SET g.gearLevel = g.gearLevel-1 WHERE g.id = ?1")
    void decrementLevel(Long id);

    //Optional<Gear> findByIdAndBicycleId(Long id, Long bicycle);
}
