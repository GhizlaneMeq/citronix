package com.example.citronix.repository;

import com.example.citronix.entity.Field;
import com.example.citronix.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TreeRepository extends JpaRepository<Tree, Long> {
    Long countByField(Field field);
    List<Tree> findByFieldAndPlantationDateAfter(Field field, LocalDateTime date);
}
