package com.example.citronix.repository;

import com.example.citronix.entity.Harvest;
import com.example.citronix.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByHarvest(Harvest harvest);
}
