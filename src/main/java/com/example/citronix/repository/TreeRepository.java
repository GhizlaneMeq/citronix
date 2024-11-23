package com.example.citronix.repository;

import com.example.citronix.entity.Field;
import com.example.citronix.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository extends JpaRepository<Tree, Long> {
    Long countByField(Field field);
}
