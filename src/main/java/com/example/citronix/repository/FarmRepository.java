package com.example.citronix.repository;

import com.example.citronix.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm,Long> {
    Boolean existsByName(String name);
}
