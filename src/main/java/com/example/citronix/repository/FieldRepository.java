package com.example.citronix.repository;

import com.example.citronix.entity.Farm;
import com.example.citronix.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Long> {
    List<Field> findAllByFarm(Farm farm);
}
