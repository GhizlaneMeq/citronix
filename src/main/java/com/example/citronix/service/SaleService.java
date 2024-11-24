package com.example.citronix.service;

import com.example.citronix.dto.Sale.SaleCreateDTO;
import com.example.citronix.dto.Sale.SaleUpdateDTO;
import com.example.citronix.entity.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleService {
    Sale save(SaleCreateDTO saleCreateDTO);
    Sale findById(Long id);
    Sale update(SaleUpdateDTO saleUpdateDTO, Long id);
    void delete(Long id);
    Page<Sale> findAll(Pageable pageable);
    List<Sale> findAllByHarvest(Long id);
}
