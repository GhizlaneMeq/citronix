package com.example.citronix.repository;

import com.example.citronix.entity.Field;
import com.example.citronix.entity.Harvest;
import com.example.citronix.entity.enums.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface HarvestRepository extends JpaRepository<Harvest,Long> {
    boolean existsByFieldAndSeasonAndHarvestDateYear(@Param("field") Field field, @Param("season")Season season, @Param("year") int year);
}
